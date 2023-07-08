package com.message.service;

import com.message.model.TrainRequest;
import com.message.repository.MessageProcessRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageProcessServiceTest {

    @InjectMocks
    MessageProcessService messageProcessService;

    @Mock
    MessageProcessRepository messageProcessRepository;

    @Test
    public void testPersist(){
        TrainRequest trainRequest = new TrainRequest();
        trainRequest.setTrainId("123");
        trainRequest.setTrainType("Train Type");
        trainRequest.setTrainLoc("Train Loc");
        messageProcessService.persist(trainRequest);
        Mockito.verify(messageProcessRepository, Mockito.times(1)).persiste(trainRequest);

    }
}
