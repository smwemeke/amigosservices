package com.amigoscode.customer;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
                // todo: check if email is valid
                // todo: check if email not taken
                customerRepository.saveAndFlush(customer);
               // todo: check if fraudster
               FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

//                       restTemplate.getForObject(
//                       //"http://localhost:8081/api/v1/fraud-check/{customerId}",
//                       "http://FRAUD/api/v1/fraud-check/{customerId}",
//                       FraudCheckResponse.class,
//                       customer.getId() );
               if(fraudCheckResponse.isFraudster()){
                   throw new IllegalStateException("Customer is fraudster");
               }
              // todo: send notification
         notificationClient.sendNotification(new NotificationRequest(
                 customer.getId(),
                 customer.getEmail(),
                 String.format("Hi %s, welcome to Amigoscode....", customer.getFirstname())
         )) ;
               }
    }
