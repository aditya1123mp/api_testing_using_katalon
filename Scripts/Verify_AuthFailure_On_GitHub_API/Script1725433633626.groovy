import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the API request with invalid authentication
def response = WS.sendRequest(findTestObject('GitHubUserRequest'))

// Verify that the response status code is 401 (Unauthorized)
WS.verifyResponseStatusCode(response, 401)

// Optionally, verify the response contains an error message
WS.verifyElementPropertyValue(response, 'message', 'Bad credentials')
