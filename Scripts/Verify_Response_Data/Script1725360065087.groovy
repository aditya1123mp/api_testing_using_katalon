import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Send the GET request and store the response
def response = WS.sendRequest(findTestObject('Object Repository/GET_PostDetails_matching_data'))

// Verify the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)

// Parse the JSON response body
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Define the expected data with partial body text for checking containment
def expectedData = [
    'userId': 1,
    'id': 1,
    'title': 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit',
    'body': 'quia et suscipit\nsuscipit'  // Use a substring of the expected body text
]

// Verify that each field contains the correct data or that the body contains the expected substring
expectedData.each { field, expectedValue ->
    if (field == 'body') {
        assert jsonResponse[field].contains(expectedValue) : "The field '${field}' does not contain the expected substring. Expected substring: ${expectedValue}, Found: ${jsonResponse[field]}"
    } else {
        assert jsonResponse[field] == expectedValue : "The field '${field}' does not contain the expected data. Expected: ${expectedValue}, Found: ${jsonResponse[field]}"
    }
}

println('All fields contain the correct data or the correct substring.')
