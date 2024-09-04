import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the API request for a non-existent user
def response = WS.sendRequest(findTestObject('Object Repository/NonExistentUserRequest'))

// Verify that the response status code is 404 (Not Found)
WS.verifyResponseStatusCode(response, 404)

// Optionally, verify the response contains an error message
WS.verifyElementPropertyValue(response, 'message', 'Not Found')
