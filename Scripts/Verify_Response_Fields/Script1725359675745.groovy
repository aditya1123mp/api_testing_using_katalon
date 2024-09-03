import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Send the GET request and store the response
def response = WS.sendRequest(findTestObject('Object Repository/GET_PostDetails'))

// Verify the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)

// Parse the JSON response body
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Define the expected fields
def expectedFields = ['userId', 'id', 'title', 'body']

// Verify that all expected fields are present in the JSON response
for (field in expectedFields) {
    assert jsonResponse.containsKey(field) : "The response does not contain the expected field: ${field}"
}

println('All expected fields are present in the response.')
