package TestBase;
import org.openqa.selenium.*;
import PageObjects.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.security.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.DOMConfiguration;
import java.util.Properties;

public class SnatchBotTests {
    public WebDriver driver;
    private FluentWait<WebDriver> wait;
    public HomePage homePage;
    public ChatBotIframe chatBotFrame;
    private Logger log=LogManager.getLogger(SnatchBotTests.class);
    //public PropertyReaderClass reader=new PropertyReaderClass();
    private PropertyReaderClass reader = PropertyReaderClass.getInstance();
    public static ChromeOptions options = new ChromeOptions();
    SnatchBotTests(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver");
        DOMConfigurator.configure("src/main/resources/Configurations/log4j.xml");
        log.info("Going to open chrome in incognito mode");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        log.info("===Initializing Webdriver===");
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(NotFoundException.class);
        homePage= PageFactory.initElements(driver,HomePage.class);
        chatBotFrame=PageFactory.initElements(driver,ChatBotIframe.class);
        driver.manage().window().maximize();
        log.info("===Webdriver Started Successfully===");
        driver.manage().deleteAllCookies();
        log.info("===Opening Website===" + reader.getPropValues("WEBSITE_LINK") );
        driver.get(reader.getPropValues("WEBSITE_LINK"));
        log.info("Snatch Bot home page has been loaded successfully");
    }

    @BeforeMethod(groups = {"Getting Chatbot Cost Intent","Explain-chatbots-Intent","Contact-SnatchBot-Support-intent"})
    void waitingtoLoadChatBotIntents() throws InterruptedException {
        Thread.sleep(15000);
        wait.until(ExpectedConditions.visibilityOf(homePage.snatchBotImage));
        Assert.assertTrue(homePage.snatchBotImage.isDisplayed());
        log.info("Assertion passed -> Main SnatchBot image has been dispalyed");
        wait.until(ExpectedConditions.visibilityOf(homePage.chatboxButton));
        log.info("Chat bot icon is pressed");
        homePage.clickonChatboxButton();
        log.info("Switching to Chatbot iframe");
        driver.switchTo().frame(homePage.iframe);
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.chatInput));
        Assert.assertTrue(chatBotFrame.chatInput.isDisplayed());
        log.info("Assertion passed -> ChatBox text input has been displayed");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.nameEnquirymessage));
        chatBotFrame.interactWithChatInput();
        log.info("Going to Enter Customer name : " + reader.getPropValues("CUSTOMER_NAME"));
        chatBotFrame.chatInput.sendKeys(reader.getPropValues("CUSTOMER_NAME"));
        log.info("Waiting for 3 Seconds");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        log.info("Customer name has been typed...Pressing Enter");
        chatBotFrame.chatInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(chatBotFrame.nameConfirmationText.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.confirmNameButton));
        chatBotFrame.confirmName();
        log.info("Customer name is being displayed in chat screen");
        log.info("Going to Check if name has been reflected on a message displayed by Chatbot");
        Assert.assertTrue(chatBotFrame.nameConfirmationText.getText().contains(reader.getPropValues("CUSTOMER_NAME")));
        log.info("Assertion passed Customer name has been displayed");
        log.info("Waiting for 10 seconds");
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.askIntendtext));
        Assert.assertTrue(chatBotFrame.askIntendtext.isDisplayed());
        log.info("Buttons Displayed : Explain chatbots, Make a chatbot, UseCases, Features, Costs, Contact SnatchBot");
    }

    @Test(groups = "Getting Chatbot Cost Intent")
    void gettingCostIntent()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.info("Going to Click on cost button");
        chatBotFrame.clickOnCostbutton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.buildChatbotText));
        log.info("TEXT DISPLAYED : Are you looking to have one or two chatbots built for you?  \uD83E\uDD16 \uD83E\uDD16:");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.buidAfewButton));
        chatBotFrame.clickOnbuildAfewButton();
        log.info("A few button is clicked");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.costStatergytext));
        log.info(chatBotFrame.getCoststrategyText());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.approximatelyButton));
        chatBotFrame.clickApproximatelyButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.costDisplaytext));
        log.info("Approximately cost of Chatbot is displayed");
        log.info(chatBotFrame.displayeApproximatelyCost());
        log.info("Waiting for Done button to be displayed");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.doneButton));
        chatBotFrame.clickDoneButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.morePricingtext));
        log.info("Do you need any other information about our pricing? is displayed");
        chatBotFrame.noButtonClick();
        log.info("No is clicked");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.whatElsetext));
        log.info("Text displayed " + chatBotFrame.whatElsetext.getText() );
        chatBotFrame.interactWithChatInput();
        chatBotFrame.chatInput.sendKeys("exit");
        log.info("Waiting for 3 Seconds");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        log.info("Exit has been typed...Pressing Enter");
        chatBotFrame.chatInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.quitConversation));
        chatBotFrame.clickYesButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.byeText));
        driver.switchTo().defaultContent();
        chatBotFrame.closeChat();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups ={"Contact-SnatchBot-Support-intent"})
    void contactSnatchBotSupport()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.info("Going to Click on Contact Snatchbot Support button");
        chatBotFrame.contactSupport();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.info(chatBotFrame.getTextContactSupport());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.contactSupportText));
        Assert.assertTrue(chatBotFrame.getTextContactSupport().contains(reader.getPropValues("CUSTOMER_NAME")));
        log.info("Customer name has been displayed in Contact Support text");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.yesButton));
        chatBotFrame.clickYesButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.askEmailText));
        chatBotFrame.interactWithChatInput();
        log.info("Going to Enter Customer name : " + reader.getPropValues("CUSTOMER_EMAIL"));
        chatBotFrame.chatInput.sendKeys(reader.getPropValues("CUSTOMER_EMAIL"));
        log.info("Waiting for 3 Seconds");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        chatBotFrame.chatInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.featureButton));
        chatBotFrame.clickFeatureInquiryButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.agreeButton));
        chatBotFrame.clickAgreeButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.supportSuccessContent));
        Assert.assertTrue(chatBotFrame.supportSuccessContent.isDisplayed());
        driver.switchTo().defaultContent();
        chatBotFrame.closeChat();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups = {"Explain-chatbots-Intent"})
    void explainChatBotIntent() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.explainChatbotButton));
        log.info("Clicking Explain Chatbot button");
        chatBotFrame.clickExplainChatbot();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.chatbotExplainDefination));
        Assert.assertEquals("Basically, we chatbots are just software applications, like any other application you use on your computer. The important difference is that people interface with us using conversation. Shall I say more about this? \uD83D\uDC40", chatBotFrame.getTextExplainChatbot());
        log.info("Assertion passed -> Explain Chat bot text displayed");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.moreAboutChatbots));
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.tellmeMorebutton));
        Assert.assertTrue(chatBotFrame.tellmeMorebutton.isDisplayed());
        log.info("Tell me more button is clicked to know more about chat bot");
        chatBotFrame.tellMeMore();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.moreExplainationChatbotText));
        Assert.assertEquals("Having a conversational interface means that with a chatbot you talk to work with the software, instead of clicking buttons in a graphical interface.",chatBotFrame.getTellmeMoreText());
        log.info("Assertion passed");
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.chatbotButtons));
        chatBotFrame.chatBotButtons();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.moreInformation));
        Assert.assertEquals("Now, are you ready for information about another, more sophisticated, \uD83E\uDDD9\u200D♂️ \uD83E\uDDD9\u200D♀️  feature of chatbots?",chatBotFrame.chatbotButtonDefination());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.yesButton));
        chatBotFrame.clickYesButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.nlpChatbot));
        Assert.assertEquals("The other, and less obvious, feature is our ability to process your natural language, it's called NLP. NLP allows chatbots to have an understanding of your intents and of entities. Does that sound impressive?\uD83D\uDD7A",chatBotFrame.nlpChatbotExplaination());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.wowButton));
        chatBotFrame.clickWowButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.moreNLPText));
        Assert.assertEquals("OK, I have to admit, we're not nearly as capable as you humans are...\uD83D\uDEB6\u200D♀️\uD83D\uDEB6\u200D♂️At least not yet! But we try. To improve we use a form of iterative learning called machine learning. Do you want to play a game \uD83C\uDFC0 to test my understanding of language?",chatBotFrame.moreAboutNLP());
        log.info("Sleeping for 10 seconds");
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.noproceedButton));
        chatBotFrame.noButtonClick();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.registrationText));
        Assert.assertEquals("You can register for free now and start building your own chatbot from scratch or based on one of the templates.",chatBotFrame.getRegistrationText());
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.registerButton));
        chatBotFrame.clickRegisterButton();
        wait.until(ExpectedConditions.visibilityOf(chatBotFrame.registerText));
        Assert.assertEquals(reader.getPropValues("REGISTER_LINK"),chatBotFrame.getRegisterLink());
        log.info("Registerlink is displayed :" +reader.getPropValues("REGISTER_LINK"));
        driver.switchTo().defaultContent();
        chatBotFrame.closeChat();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterSuite (alwaysRun = true)
    void TearDown(){
        if(driver!=null)
            driver.quit();
    }
}
