import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Send the GET request and store the response
def response = WS.sendRequest(findTestObject('Object Repository/GET_Posts'))

// Verify that the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)
