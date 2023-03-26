package SeleniumRecap;

public class InterviewQuestions {

    /*
    1. What are the advantages and disadvantages of Selenium?

    Advantages: -Free Resource
                -It supports multiple languages and browsers
                -it has big community
   DisAdvantages: -You canot automate captcha, pictures, mobile applications etc...
                    -There is no direct call (customer service) for support
                    -It only automates Web application(browsers)
                    -it does not have any system to generate report, so we use
                    external resources(testing, cucumber etc..)

     2. What type of testing can you automate with Selenium?

        -Regression
        -Smoke
        -Functional test(positive and negative testing)

     3. What are the test types you do not automate with Selenium?
        -Performance Testing(Jmeter --> it is not really hard to learn)
        -Manual Testing (captcha, pictures)
        -Non-Functional Testing(stress testing, loading testing, performance...
        -AdHoc Testing(randomly testing)

     4. What is locator in Selenium? What type of locators do you use in your framework?
           --> Locator is a way to find the element/s from DOM(development tool/page)
          The locators that I am using in my framework are:

          -->ID-> find the element with ID attribute
          -->Name -> find element with Name attribute
          -->ClassName-> find element with className attribute
          -->TagName -> find the element with TagName
          -->LinkText ->find the element with "a" tagname and "text"
          -->PartialLinkText -> find element with "a" tagname and and "partialText" or fullText
          --> CSS ->find the element with CSS (id or class) --> for id (#) , for class(.)
          --> Xpath ->find the element withXpath

      5. How do you handle Dynamic elements in UI automation? (CVS -question)

        --> In my project, I've faced many dynamic elements during UI automation
            --> To handle this issue I did:
             *   -I used parent-child relationship for the elements
             ***  -I used different ways to locate the elements(like following -sibling, preceding sibling, contains etc..)
             *  -I found the element with different attribute which is not dynamic

      6. Difference between driver.get() and driver.Navigate()?

        Navigate() --> it doesn;t wait webElement to be loaded from page (it waits for only specific elements that you are looking from page)
                   --> It has methods(to, refresh, back, forward)

        Get() --> It waits all the WebElements from page to be loaded
              --> it does not have any methods

      7. Different between driver.close() and driver.quit()?

        Driver.close() --> It specifically closes the window that your driver is pointing.
                       * --> it closes only one tab

        Driver.quit() --> It closes all the tabs that were opened during the automation run.

      8. What is Xpath and can you tell me about types of Xpath? Which one do you use the most?
        8.1 --> What is the difference between Absolute and Relative Xpath?
        --> XPATH: It is one of the locators that I use in Selenium to find the element
            --> There are two types of Xpath:
                1. Absolute Xpath:
                   - it goes from all the way top(html) to child
                  -It starts with single slash(/)

                2. Relative Xpath:
                 - It goes directly to the child or parent/child
                    ex: //div[@id='parent']//a[.='child']
                    ex:  //div[@id='parent']//following-sibling::a  --> following sibling
                 - It starts with double slash(//)

        NOTE: I use definitely the relative xpath the most since it is more functional
        and effective to locate the elements.

      9. How do you handle drop - downs? (Static or Dynamic drop - down)

        In my project, I was handling the drop-downs with different ways: First

            * I would definitely check the tag of the WebElement(location)
             *If the location has "SELECT" tagname then --> I use Select Class
                ex: Select select = new Select(locationOf Element);
             *If the location doesn't have "SELECT" tagname then --> I can use:

                -->Actions class methods like click or WebElements method click and choose option
                --> I would use sendKeys() to choose the option

        10. Can you Tell me what do you know about Select class and it's methods?

            Select class is a way to handle Drop-Downs:
                --> It is really useful for my project.
                --> The WebElement must have Select tagname

              -Select select = new Select(location
                * select.selectByVisibleText("textValue")
                * select.selectByValue("Value")
                * select.selectByIndex("indexNumber")
                * select.getFirstSelectedOption() --> it will give you default option selected
                * select.getOptions() --> it will give you all options(List<String>)

        11. What kind of exceptions have you faced in your automation Framework?

           --> NOSUCHELEMENT EXCEPTION

           --> STALEELEMENT REFERENCE EXCEPTION
           --> ELEMENT INTERCEPTED EXCEPTION
           --> ELEMENT ISNOT INTERACTABLE EXCEPTION
           --> NOSUCH WINDOW EXCEPTION
           --> NOSUCH FRAME EXCEPTION
           --> TESTING EXCEPTION
           --> UNHANDLE ALERT EXCEPTION
           --> TIMEOUT EXCEPTION
           --> INVALID SELECTED EXCEPTION

        12. How do you handle Stale Element Reference Exception?

            In my project, this exception is one of the hard ones that was giving me headache:

              --> This exception happens when:
                * The DOM is not updated fast
                * The DOM's e;lement values is changed
                * The page is refreshed

              --> Wait times might solve the issue
                --> I would use Thread.sleep or Explicitly Wait with condition
            *** --> I would reassign and reinitialize the WebElement
                --> I would refresh the page

        13. how do you handle pop-ups? and Can you Tell me the methods that you handle JS alert?

            There are different types of pop-ups that I've faced during automation?

            1. Operation System(OS): We cannot handle it directly with Selenium

            2. HTML alert/pop-up: I just need to find the element and click on it (like Ok or Cancel Btn)

            3. JavaScript alert/pop-up: I handle it with Alert Interface

                Alert alert=driver.switchTo().alert();

                alert.accept() --> it clicks OK button from alert
                alert.dismiss() --> it clicks "Cancel" button from alert
                alert.gettext()--> it gets the Text from alert
                alert.sendKeys() --> it sends the key to the alert

         14. What do you know about iframe? And How do you handle this in your automation?

            --> Iframe is html inside of html.
            --> It is used for protection purposes.
            --> It is widely used for Ads, documents or videos

            --> First switch your frame based on the value of WebElement

                --> driver.switchTo().frame(id or name)
               --> driver.switchTo().frame(WebElement)
               --> driver.switchTo().frame(index)
               --> driver.switchTo().ParentFrame()--> it will go to the parent frame
               --> driver.switchTo().defaultContent() --> it will no matter what go to the main html directly
                                                      --> no matter what how many times you switch your frame from parent to child
                                                      with this method, it will directly skip all the parents and go to the main html.

            NOTE: If you do not handle this iframe, you will get NOSUCHElement exception
            NOTE: If the value of switchFrame is wrong, you will get NoSuchFrame exception

            15 What do you know about Actions class and can you Tell me the methods you used the most during automation?

            Actions calss basically does the functionality of mouse. i can say it is really useful
             in some cases during my automation to handle some elements. Some of the important methods are:

           IQ ***** --> ContextClick--> It right clicks on the WebElement   IQ: interview question
                    --> DoubleClick --> it double clicks the element
                    --> DragAndDrop --> it drags and drops the element from one spot the another spot
                    --> ClickAndHold--> It clicks and holds the element
                 ***--> MoveToElement --> It hovers over element
                    --> release --> It releases the element that you are holding (it mostly comes after clickAndHold
                    --> click() --> it clicks the element
                    --> sendKeys()--> it sends the key
             ***** --> perform() --> it performs the actions method (WITHOUT THAT IT WILL NOT WORK)


            16. What is the difference between driver.findElement and driver.FindElements?

                * Find Element: 1-driver.findElement(By.lacotor(""); Syntax
                                2. Returns single WebElement
                                3. Once it fails, it throws NoSuchElement exception

                *Find Elements: 1. driver.findElements(By.locator(""); Syntax
                                2. Returns List<WebElement>
                                3. Once it fails, it returns nothing(empty list)

           17 Can you Tell me some driver and WebElement methods you use during automation mostly?

           Driver methods: *get(), *navigate(), *getTitle(), *getCurrentURL(), *switchTo(), *quit(), *close()
                            *GetWindowhandle/s , *manage()

           WebElement Methods: *click(), *sendKeys(), *getText(), *isDisplayed(), *isSelected(),
                               *getAttribute(), *getCSSValue(), *clear(), *submit()

          18. Whta is difference between check- box and radio button?

                CheckBox --> you can click multiple boxes
                RadioButton --> you can choose only one

          19. How do you handle windows in automation?
           And What is the difference between getWindowHandle() and getWindowHandles()?

            --> to be able to handle the windows:
                --> I need to switch my driver into the specific window with my logic

                    Set<String> allWindows = driver.getWindowHandles();

                    for(String pageId : allWindows){
                    driver.switchTo.window(pageId);
                    if(driver.getTitle.contains(expectedTitle){
                    break; }

                1. Use GetWindowHandles to atore all pages id as Set
                2. Loop through all pages and switch
                3. Break the loop when title is what I am looking for

          NOTE: Get WindowHandle --> returns String with single page id
                Get WindowHandles --> return Set<String> with all unique page ids

           20. How do you scroll down-up in Web Browsers during automation?

          *****  --> I mostly use JS scrollIntoView script (I store it in my Browser Utils for any time usage)
                --> actions.scrollByAmount(x,y)
                --> Keys.PageUp or Down
                --> Keys.ArrowUp or Down

          21. How do you upload file in Selenium?

                --> First of all, you need to find the location of CHOOSE button
                --> Find the Path of the file that you are going to attach(//c://Users??usa.png
                --> the Send the keys of location to the choose button

         22. What is the difference between Assert and SoftAssert?

            Assert: is a class that have some methods to validate actual and expected data.
                Assert.assertEquals, assertTrue

                *When it fails, it throws exception right away and do not execute the next line of code.

                SoftAssert: It is a class that have some methods to validate actual and expectedd data
                    *We need to create an object
                        SoftAssert softAssert = new SoftAssert();
                   *WHen it fails, it does not throw an exception then it keeps executing the next codes.
                   *You must use Assert.all() to make it work properly otherwise ot will pass all the time.

          23. Can you tell me about your Singleton Pattern design? --> Can you make the constructor private, static final?

            Firts of all, I appreciate for this question since I like Singleton Logic because in the past I was working on my
            driver and gettoing lots of NULLPOINTER exception. With the help of Singleton, I centralize my driver which
            reduces the amount of exception I got which means it is more reliable and safe to use.

                --> I basically Encapsulate my Singleton
                    --> I need to have Private WebDriver
                    --> I need to have Private Constructor
                    --> Put if condition to check my driver is Null or Not
                    --> create a oublic method to call it from other classes.

           24. What kind of TestNG Annotation do you use in your Project?
           Can ypou tell me What is the puppose of @Parameter usage?

           Please check the subLime --> It is explained in details recently

           25. What do you know about @DataProvider and Why do you use it?

                Please check the subLime --> It is explained in details recently

           26. What do you know about Wait times and Can you tell me the
           difference between Thread.sleep(), ImplicitlyWait, ExplicitlyWait, FluentWait?

            Please check the subLime --> It is explained in details recently













     */
























}
