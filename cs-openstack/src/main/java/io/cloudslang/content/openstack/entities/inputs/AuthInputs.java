package io.cloudslang.content.openstack.entities.inputs;

import io.cloudslang.content.openstack.constants.ExceptionMessages;
import io.cloudslang.content.openstack.entities.identity.Auth;
import io.cloudslang.content.openstack.entities.identity.PasswordCredentials;
import io.cloudslang.content.openstack.exceptions.CustomException;
import io.cloudslang.content.openstack.utils.StringUtils;

/**
 * Created by stcu on 23.05.2016.
 */
public class AuthInputs {
    public static final String AUTH_ROOT = "auth";
    private String tenantName;
    private String tenantId;
    private String username;
    private String password;

    public AuthInputs(AuthInputs.AuthInputsBuilder builder) {
        this.tenantName = builder.tenantName;
        this.tenantId = builder.tenantId;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class AuthInputsBuilder {
        private String tenantName;
        private String tenantId;
        private String username;
        private String password;

        public AuthInputs build() {
            return new AuthInputs(this);
        }

        public AuthInputs.AuthInputsBuilder withTenantName(String tenantName) throws Exception {
            this.tenantName = StringUtils.toString(tenantName, "");
            return this;
        }

        public AuthInputs.AuthInputsBuilder withTenantId(String tenantId) throws Exception {
            this.tenantId = StringUtils.toString(tenantId, "");
            return this;
        }

        public AuthInputs.AuthInputsBuilder withUsername(String username) throws Exception {
            this.username = StringUtils.toString(username, "");
            return this;
        }

        public AuthInputs.AuthInputsBuilder withPassword(String password) throws Exception {
            this.password = StringUtils.toString(password, "");
            return this;
        }
    }

    public Auth toAuth() throws Exception {
        Auth auth = new Auth();

        if (StringUtils.isNotBlank(getTenantName())) {
            auth.setTenantName(getTenantName());
        } else {
            if (StringUtils.isNotBlank(getTenantId())) {
                auth.setTenantId(getTenantId());
            } else {
                throw new CustomException(String.format(ExceptionMessages.DOUBLE_INPUTS_EMPTY, tenantName, tenantId));
            }
        }

        if (StringUtils.isNotBlank(getTenantName()) || StringUtils.isNotBlank(getTenantId())) {
            PasswordCredentials credentials = new PasswordCredentials();
            if (StringUtils.isNotBlank(getPassword()) && StringUtils.isNotBlank(getUsername())){
                credentials.setUsername(getUsername());
                credentials.setPassword(getPassword());
            } else {
                throw new CustomException("Username And Password can not be empty is tenantName" +
                        " or tenantId is provided.");
            }

            auth.setPasswordCredentials(credentials);
        }

        return auth;
    }
}
