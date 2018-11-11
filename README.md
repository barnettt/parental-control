You need to have maven installed

run: mvn clean install

In your ide run the test suite or

run: mvn test.

The customer parental control level is passed from the client to the ParentalControlService.

The value is converted to a ParentalControlLevel and compared.

If the level returned from thr movie service for a given movie id is less than the parental control
level given by a customer, then the movie viewing is allowed otherwise its not.



