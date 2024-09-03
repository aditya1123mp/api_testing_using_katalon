import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import groovy.xml.XmlSlurper

// Send the GET request and store the response
def response = WS.sendRequest(findTestObject('Object Repository/GET_Example'))

// Verify the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)

// Get the response body content as a string
def responseBody = response.getResponseBodyContent()

// Verify the response format is JSON
try {
    new JsonSlurper().parseText(responseBody)
    println('The response is in JSON format.')
} catch (Exception e) {
    WS.comment('The response is not in JSON format.')
    assert false, 'The response is not in JSON format.'
}



