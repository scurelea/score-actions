package io.cloudslang.content.xml.actions;

import com.hp.oo.sdk.content.annotations.Action;
import com.hp.oo.sdk.content.annotations.Output;
import com.hp.oo.sdk.content.annotations.Param;
import com.hp.oo.sdk.content.annotations.Response;
import com.hp.oo.sdk.content.plugin.ActionMetadata.MatchType;
import io.cloudslang.content.xml.entities.inputs.CommonInputs;
import io.cloudslang.content.xml.entities.inputs.CustomInputs;
import io.cloudslang.content.xml.services.AddAttributeService;
import io.cloudslang.content.xml.utils.Constants;

import java.util.Map;

/**
 * Created by markowis on 25/02/2016.
 */
public class AddAttribute {
    /**
     * Adds an attribute to an XML element or replaces the value if the attribute already exists.
     *
     * @param xmlDocument           XML string in which to add attribute
     * @param xPathElementQuery     XPATH query that results in an element or element list, not an attribute
     * @param attributeName         name of attribute to add or replace
     * @param value                 value of attribute to add or replace with
     * @param secureProcessing      optional - whether to use secure processing
     * @return map of results containing success or failure text, a result message, and the modified XML
     */
    @Action(name = "Add Attribute",
            outputs = {
                    @Output(Constants.OutputNames.RESULT_TEXT),
                    @Output(Constants.OutputNames.RETURN_RESULT),
                    @Output(Constants.OutputNames.RESULT_XML)},
            responses = {
                    @Response(text = Constants.ResponseNames.SUCCESS, field = Constants.OutputNames.RESULT_TEXT, value = Constants.SUCCESS, matchType = MatchType.COMPARE_EQUAL),
                    @Response(text = Constants.ResponseNames.FAILURE, field = Constants.OutputNames.RESULT_TEXT, value = Constants.FAILURE, matchType = MatchType.COMPARE_EQUAL, isDefault = true, isOnFail = true)})
    public Map<String, String> execute(
            @Param(value = Constants.InputNames.XML_DOCUMENT, required = true) String xmlDocument,
            @Param(value = Constants.InputNames.XPATH_ELEMENT_QUERY, required = true) String xPathElementQuery,
            @Param(value = Constants.InputNames.ATTRIBUTE_NAME, required = true) String attributeName,
            @Param(value = Constants.InputNames.VALUE, required = true) String value,
            @Param(Constants.InputNames.SECURE_PROCESSING) String secureProcessing) {

        CommonInputs inputs = new CommonInputs.CommonInputsBuilder()
                .withXmlDocument(xmlDocument)
                .withXpathQuery(xPathElementQuery)
                .withSecureProcessing(secureProcessing)
                .build();

        CustomInputs customInputs = new CustomInputs.CustomInputsBuilder()
                .withAttributeName(attributeName)
                .withValue(value)
                .build();

        return new AddAttributeService().execute(inputs, customInputs);
    }
}
