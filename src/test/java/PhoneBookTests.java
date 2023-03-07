import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Contact;
import ru.netology.PhoneBook;

import java.util.*;

public class PhoneBookTests {
    Contact cont1, cont2, cont3, newCont;
    PhoneBook book;
    Map<String, List<Contact>> bookMap;

    @BeforeEach
    public void cratePhoneBook() {
        cont1 = new Contact("Ivan", "123");
        cont2 = new Contact("Petr", "345");
        cont3 = new Contact("Semen", "678");
        newCont = new Contact("Ann", "000");
        bookMap = new HashMap<>();
        bookMap.put("family", new ArrayList(Arrays.asList(cont1, cont2)));
        bookMap.put("friends", new ArrayList(Arrays.asList(cont2, cont3)));
        book = new PhoneBook(bookMap);

    }

    @AfterEach
    public void deletePhoneBook() {
        bookMap = null;
        book = null;
    }

    @Test
    public void testFoundGroup() {
        // given:
        List<Contact> expected = Arrays.asList(cont1, cont2);

        // when:
        List<Contact> result = book.foundGroup("family");

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFoundContact() {
        // given:
        Contact expected = cont2;

        // when:
        Contact result = book.foundContact("345");

        // then:
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testAddContact() {
        // given:
        Map<String, List<Contact>> expected = new HashMap<>();
        expected.put("family", new ArrayList(Arrays.asList(cont1, cont2, newCont)));
        expected.put("friends", new ArrayList(Arrays.asList(cont2, cont3, newCont)));

        // when:
        Map<String, List<Contact>> result = book.addContact(newCont, new String[]{"family", "friends"});

        // then:
        Assertions.assertEquals(expected, result);

    }
}
