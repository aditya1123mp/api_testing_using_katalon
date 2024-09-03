import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Define the acceptable response time in milliseconds (e.g., 2000 ms = 2 seconds)
int maxAcceptableResponseTime = 2500 // Increased limit

// Capture the start time
long startTime = System.currentTimeMillis()

// Send the GET request and store the response
def response = WS.sendRequest(findTestObject('Object Repository/GET_PostDetails_verify_response_time'))

// Capture the end time
long endTime = System.currentTimeMillis()

// Calculate the response time
long responseTime = endTime - startTime

// Verify the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)

// Verify that the response time is within acceptable limits
assert responseTime <= maxAcceptableResponseTime : "Response time exceeded acceptable limit. Actual: ${responseTime} ms, Max Acceptable: ${maxAcceptableResponseTime} ms"

println("Response time is within acceptable limits: ${responseTime} ms")
