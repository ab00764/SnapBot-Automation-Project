package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChatBotIframe {
    @FindBy(how = How.XPATH, using = "//input[@id='chat_input']")
    public WebElement chatInput;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'There’s lots I can show you but first please let me know your name.')]")
    public WebElement nameEnquirymessage;

    @FindBy(how=How.XPATH, using= "//span[contains(text(),'Yes')]")
    public WebElement confirmNameButton;

    @FindBy(how=How.XPATH, using= "//span[contains(text(),'No')]")
    public WebElement denyNameButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Explain chatbots')]")
    public WebElement explainChatbotButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Make a chatbot')]")
    public WebElement makeChatbotButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Use cases')]")
    public WebElement useCaseButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Features')]")
    public WebElement featureButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Contact SnatchBot')]")
    public WebElement contactSupportButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Costs')]")
    public WebElement costsButton;

    @FindBy (how = How.XPATH ,using = "//p[contains(text(),'Good to chat to you. Did I get your name right?')]")
    public WebElement nameConfirmationText;

    @FindBy (how=How.XPATH,using="//p[contains(text(),'You can click a button or type freely. And there are more options in the persistent menu (to the left of the chat bar). So, what would you like me to talk about?')]")
    public WebElement askIntendtext;

    @FindBy (how = How.XPATH,using = "//p[contains(text(),'Basically, we chatbots are just software applications, like any other application you use on your computer.')]")
    public WebElement chatbotExplainDefination;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Tell me')]")
    public WebElement tellmeMorebutton;

    @FindBy(how = How.XPATH, using="//p[contains(.,'Shall I say more about this?')]")
    public WebElement moreAboutChatbots;

    @FindBy(how = How.XPATH,using="//p[contains(.,'Having a conversational interface means')]")
    public WebElement moreExplainationChatbotText;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Chatbot buttons?')]")
    public WebElement chatbotButtons;

    @FindBy(how = How.XPATH, using="//p[contains(.,'Now, are you ready for information about another,')]")
    public WebElement moreInformation;

    @FindBy(how = How.XPATH, using="//span[contains(.,'No thanks')]")
    public WebElement noThanksButton;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Yes')]")
    public WebElement yesButton;

    @FindBy (how = How.XPATH,using = "//p[contains(.,'NLP')]")
    public WebElement nlpChatbot;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Wow, it does!')]")
    public WebElement wowButton;

    @FindBy(how = How.XPATH, using="//p[contains(.,'I have to admit')]")
    public WebElement moreNLPText;

    @FindBy(how = How.XPATH, using="//span[contains(.,'No')]")
    public WebElement noproceedButton;

    @FindBy(how = How.XPATH, using="//p[contains(.,'You can register for free now and start building your own chatbot')]")
    public WebElement registrationText;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Register')]")
    public WebElement registerButton;

    @FindBy(how = How.XPATH, using="//span[contains(.,'A few')]")
    public WebElement buidAfewButton;

    @FindBy(how = How.XPATH , using = "//p[contains(.,'Great! \uD83E\uDD1C \uD83E\uDD1B  Click here to register and start using SnatchBot:')]")
    public WebElement registerText;

    @FindBy(how = How.XPATH , using = "//a[contains(text(),'here')]")
    public WebElement registerLink;

    @FindBy (how = How.XPATH, using= "//p[contains(.,'Are you looking to have one or two chatbots built for you?')]")
    public WebElement buildChatbotText;

    @FindBy (how = How.XPATH, using= "//p[contains(.,'For individual chatbot builds our costs depend on the time')]")
    public WebElement costStatergytext;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Approximately?')]")
    public WebElement approximatelyButton;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'The good news is we are highly competitive and, typically, our chatbot builds cost around $3,000.')]")
    public WebElement costDisplaytext;

    @FindBy(how = How.XPATH, using="//span[contains(.,'Done')]")
    public WebElement doneButton;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'Do you need any other information about our pricing?')]")
    public WebElement morePricingtext;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'What else can I do for you?')]")
    public WebElement whatElsetext;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'quit this conversation')]")
    public WebElement quitConversation;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'Bye')]")
    public WebElement byeText;

    @FindBy (how=How.CSS,using= "#sntch_close")
    public WebElement closeChatButton;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'like to contact SnatchBot. Right?')]")
    public WebElement contactSupportText;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'tell me your \uD83D\uDCE7 email')]")
    public WebElement askEmailText;

    @FindBy (how=How.XPATH,using= "//span[contains(.,'⚙️ Features Inquiry')]")
    public WebElement featureInquirybutton;

    @FindBy (how=How.XPATH,using= "//span[contains(.,'\uD83D\uDC4D I Agree')]")
    public WebElement agreeButton;

    @FindBy (how=How.XPATH,using= "//p[contains(.,'Thank you, your data has just been added to our contacts. We will contact you in the next couple of days.')]")
    public WebElement supportSuccessContent;


    public void clickAgreeButton(){
        agreeButton.click();
    }

    public void clickFeatureInquiryButton(){
        featureInquirybutton.click();
    }


    public String getTextContactSupport(){
        return contactSupportText.getText();
    }


    public void closeChat (){closeChatButton.click();}


    public void clickDoneButton (){doneButton.click();}


    public String displayeApproximatelyCost(){
        return costDisplaytext.getText();
    }

    public void contactSupport(){
        contactSupportButton.click();
    }

    public void clickApproximatelyButton (){approximatelyButton.click();}
    public String getRegisterLink(){
        return registerLink.getAttribute("href");
    }
    public String getRegistrationText(){
        return registrationText.getText();
    }
    public void clickRegisterButton(){
        registerButton.click();
    }

    public void noButtonClick(){
        noproceedButton.click();
    }
    public String chatbotButtonDefination(){
        return moreInformation.getText();
    }
    public String moreAboutNLP(){
        return moreNLPText.getText();
    }
    public void clickWowButton(){
        wowButton.click();
    }
    public void clickYesButton(){
        yesButton.click();
    }

    public void interactWithChatInput(){
        chatInput.click();
    }
    public void clickExplainChatbot (){
        explainChatbotButton.click();
    }
    public void confirmName(){
        confirmNameButton.click();
    }
    public String getTextExplainChatbot(){
        return chatbotExplainDefination.getText();
    }

    public void tellMeMore(){
        tellmeMorebutton.click();
    }

    public String getTellmeMoreText(){
        return moreExplainationChatbotText.getText();
    }
    public String nlpChatbotExplaination(){
        return nlpChatbot.getText();
    }
    public void chatBotButtons(){
        chatbotButtons.click();
    }
    public void clickOnCostbutton(){
        costsButton.click();
    }

    public void clickOnbuildAfewButton (){
        buidAfewButton.click();
    }
    public String getCoststrategyText(){
        return costStatergytext.getText();
    }
}


