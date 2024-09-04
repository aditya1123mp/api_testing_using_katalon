import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the API request without authorization
def response = WS.sendRequest(findTestObject('UnauthorizedAccessRequest'))

// Verify that the response status code is 401 (Unauthorized)
WS.verifyResponseStatusCode(response, 401)

// Optionally, verify the response contains an error message about authorization
WS.verifyElementPropertyValue(response, 'message', 'Requires authentication')
