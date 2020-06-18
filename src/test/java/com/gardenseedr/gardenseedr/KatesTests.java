package com.gardenseedr.gardenseedr;

import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GardenseedrApplication.class)
@AutoConfigureMockMvc
public class KatesTests {

    private User testUser;
    private HttpSession httpSession;
    private Garden testGarden;

    @Autowired
    private MockMvc mvc;

    @Autowired
    GardenRepository gardenDao;
    @Autowired
    NoteRepository noteDao;
    @Autowired
    PlantRepository plantDao;
    @Autowired
    SquareRepository squareDao;
    @Autowired
    UserRepository userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser");

        // Creates the test user if not exists
        if(testUser == null){
            User newUser = new User();
                newUser.setUsername("testUser");
                newUser.setPassword(passwordEncoder.encode("pass"));
                newUser.setEmail("testUser@codeup.com");
                newUser.setFirst_name("Testy");
                newUser.setLast_name("McTesterson");
                newUser.setIs_admin(false);
                newUser.setZipcode(78861);
            testUser = userDao.save(newUser);
        }


        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
        // Throws a Get request to /dashboard/success and expect a redirection to the UserDashboard after being logged in
        httpSession = this.mvc.perform(get("/dashboard/success").with(csrf())
                .param("username", "testUser")
                .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("redirect:/dashboard/" + testUser.getId()))
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Test
    public void testCreateGarden() throws Exception{
        // Makes a Post request to /posts/create and expect a redirection to the Post
        // Makes a Post request to /dashboard/{userId} and expect a redirection to the Garden
        this.mvc.perform(
                post("/dashboard/{userId}").with(csrf())
                        .session((MockHttpSession) httpSession)
                        // Add all the required parameters to your request like this
                        .param("title", "test")
                        .param("body", "test to create post"))
                .andExpect(status().is3xxRedirection());


        public String createGarden(@ModelAttribute Garden newgarden, @PathVariable long userId) {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

            newgarden.setCreated(today);
            newgarden.setUser(userDao.getOne(userId));

            gardenRepo.save(newgarden);

            return "redirect:/garden/" + newgarden.getId();
    }




}