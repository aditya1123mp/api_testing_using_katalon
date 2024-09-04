import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject

// Define acceptable payload size limit (e.g., 5 KB)
int maxPayloadSize = 5 * 1024  // 5 KB in bytes

// Send the API request
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/GetGitHubUser'))

// Get the response payload as a string
String responseBody = response.getResponseBodyContent()

// Calculate the size of the response payload
int payloadSize = responseBody.getBytes('UTF-8').length

// Verify that the payload size is within acceptable limits
WS.verifyLessThanOrEqual(payloadSize, maxPayloadSize)
