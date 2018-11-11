# Parental Control Service

You need to have maven installed

## Run code
run: mvn clean install
run: mvn test.

### description
The customer parental control level is passed from the client to the ParentalControlService.

The value is converted to a ParentalControlLevel and compared.

If the level returned from thr movie service for a given movie id is less than the parental control
level given by a customer, then the movie viewing is allowed otherwise its not.



