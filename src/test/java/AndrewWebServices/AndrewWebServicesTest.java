package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AndrewWebServicesTest {
    InMemoryDatabase fakeDatabase;
    RecSysStub stubRecommender;
    PromoService mockPromoService;
    AndrewWebServices aws;

    @Before
    public void setUp() {
        // Fake
        fakeDatabase = new InMemoryDatabase();
        fakeDatabase.addUser("Scotty", 17214);

        // Stub
        stubRecommender = new RecSysStub();

        // Mock
        mockPromoService = mock(PromoService.class);

        aws = new AndrewWebServices(fakeDatabase, stubRecommender, mockPromoService);
    }

    @Test
    public void testLogIn() {
        assertTrue(aws.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        assertEquals("Animal House", aws.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        aws.sendPromoEmail("test@example.com");
        verify(mockPromoService, times(1)).mailTo("test@example.com");
    }

    @Test
    public void testNoSendEmail() {
        
        verify(mockPromoService, never()).mailTo(anyString());
    }
}
