import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the API request without a payload
def response = WS.sendRequest(findTestObject('Object Repository/CreateUserRequest'))

// Verify that the response status code is 201 (Created)
// Note: JSONPlaceholder may return 201 even without a payload, but this is for demonstration.
WS.verifyResponseStatusCode(response, 201)

// Optionally, verify the response does not contain expected fields due to missing payload
WS.verifyElementPropertyValue(response, 'title', null)
WS.verifyElementPropertyValue(response, 'body', null)
