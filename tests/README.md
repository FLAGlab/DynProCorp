# Tests

All implementations for the exemplars in the repository **must** comply with the following test scenarios.

## Test set-up

To compare the different implementations fairly, we use specific scenarios setting-up all program entities and their relations.

## Use Cases

All tests cases are described from use cases describing the intended interaction and result of the test. Each test case may use a defined set of data (also available in the repository)

### Case 1 - Name


Each test case contains a `data-X-env-Y` file for each of the defined environments in the test case (X is the number of the test case, and Y is the number of the environment), describing the order in which the events to the application are sent (messages sent to test the case).

Additionally, each case contains an expected output file (`out-X-env-Y`) with the **exact** result expected for execution of the test case X runing on environment Y.
