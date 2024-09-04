import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send the API request
response = WS.sendRequest(findTestObject('Object Repository/VerifyAPIEndpoint'))

// Verify the response status code
WS.verifyResponseStatusCode(response, 200)

// Optional: Verify response content
WS.verifyElementPropertyValue(response, 'login', 'octocat')
