import com.kms.katalon.core.testobject.TestObjectProperty

// Define expected parameters
Map<String, String> expectedQueryParams = [
    'param1' : 'value1',
    'param2' : 'value2'
]

// Get the actual query parameters from the request object
List<TestObjectProperty> actualQueryParams = requestObject.getRestParameters()

// Verify each query parameter
actualQueryParams.each { param ->
    String paramName = param.getName()
    String paramValue = param.getValue()
    
    // Assert that the parameter name exists in the expected parameters
    assert expectedQueryParams.containsKey(paramName) : "Unexpected parameter: ${paramName}"
    
    // Assert that the parameter value matches the expected value
    assert expectedQueryParams[paramName] == paramValue : "Mismatched value for parameter: ${paramName}. Expected: ${expectedQueryParams[paramName]}, Actual: ${paramValue}"
}

println("All query parameters are correctly passed.")



