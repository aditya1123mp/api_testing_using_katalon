import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject

// Send the API request
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/VerifyGitHubAPIHeaders'))

// Extract the response headers
Map<String, List<String>> headers = response.getHeaderFields()

// Verify the 'Content-Type' header
String contentType = headers['Content-Type'][0]
WS.verifyEqual(contentType, 'application/json; charset=utf-8')

// Optionally, verify other headers (case-insensitive)
String server = headers['Server'][0].toLowerCase()
WS.verifyEqual(server, 'github.com')
