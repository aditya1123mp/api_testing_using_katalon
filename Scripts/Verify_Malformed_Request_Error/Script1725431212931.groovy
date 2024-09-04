import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the malformed API request
def response = WS.sendRequest(findTestObject('Object Repository/Malformed_Request'))

// Verify that the response status code is 404 (Not Found)
WS.verifyResponseStatusCode(response, 404)

// Optionally, verify that the response contains the expected error message
WS.verifyElementPropertyValue(response, 'message', 'Not Found')
