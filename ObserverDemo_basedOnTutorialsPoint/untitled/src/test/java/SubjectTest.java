import com.observer.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectTest {
    @Test
    public void should_display_subscriber_output_when_setState_given_subject_with_one_subscriber(){
        //Given
        Subject subject = new Subject();
        Subscriber subscriber = new Subscriber("Gabriel", subject);
        String expected = "My name is Gabriel, I am a subscriber. The message is: Hello World!";

        //When
        subject.setState("Hello World!");

        //Then
        assertEquals(expected, subscriber.status);
    }

    @Test
    public void should_display_subscribers_output_when_setState_given_subject_with_many_subscribers(){
        //Given
        Subject subject = new Subject();

        Subscriber subscriberAdrian = new Subscriber("Adrian", subject);
        Subscriber subscriberAmiel = new Subscriber("Amiel", subject);
        Subscriber subscriberJamie = new Subscriber("Jamie", subject);
        Subscriber subscriberNoel = new Subscriber("Noel", subject);
        Subscriber subscriberRyanJay = new Subscriber("Ryan Jay", subject);
        Map<String, String> expected = new HashMap<>();
        expected.put("Adrian", "My name is Adrian, I am a subscriber. The message is: bring your umbrella");
        expected.put("Amiel", "My name is Amiel, I am a subscriber. The message is: bring your umbrella");
        expected.put("Jamie", "My name is Jamie, I am a subscriber. The message is: bring your umbrella");
        expected.put("Noel", "My name is Noel, I am a subscriber. The message is: bring your umbrella");
        expected.put("Ryan Jay", "My name is Ryan Jay, I am a subscriber. The message is: bring your umbrella");


        //When
        subject.setState("bring your umbrella");

        //Then
        assertEquals(expected.get("Adrian"), subscriberAdrian.status);
        assertEquals(expected.get("Amiel"), subscriberAmiel.status);
        assertEquals(expected.get("Jamie"), subscriberJamie.status);
        assertEquals(expected.get("Noel"), subscriberNoel.status);
        assertEquals(expected.get("Ryan Jay"), subscriberRyanJay.status);
    }

    @Test
    public void should_display_only_subscribers_output_when_setState_given_subject_with_many_subscribers(){
        //Given
        Subject subject = new Subject();
        Subject differentSubject = new Subject();

        Subscriber subscriberAdrian = new Subscriber("Adrian", subject);
        Subscriber subscriberAmiel = new Subscriber("Amiel", subject);
        Subscriber subscriberJamie = new Subscriber("Jamie", subject);

        Subscriber subscriberNoel = new Subscriber("Noel", differentSubject);
        Subscriber subscriberRyanJay = new Subscriber("Ryan Jay", differentSubject);

        Map<String, String> expected = new HashMap<>();
        expected.put("Adrian", "My name is Adrian, I am a subscriber. The message is: turn on your flashlight");
        expected.put("Amiel", "My name is Amiel, I am a subscriber. The message is: turn on your flashlight");
        expected.put("Jamie", "My name is Jamie, I am a subscriber. The message is: turn on your flashlight");

        expected.put("Noel", "");
        expected.put("Ryan Jay", "");

        //When
        subject.setState("turn on your flashlight");

        //Then
        assertEquals(expected.get("Adrian"), subscriberAdrian.status);
        assertEquals(expected.get("Amiel"), subscriberAmiel.status);
        assertEquals(expected.get("Jamie"), subscriberJamie.status);
        assertEquals(expected.get("Noel"), subscriberNoel.status);
        assertEquals(expected.get("Ryan Jay"), subscriberRyanJay.status);
    }
}
