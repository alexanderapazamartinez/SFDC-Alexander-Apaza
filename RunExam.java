import Login.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class RunExam {
    String username = "alex.apaza202@gmail.com";
    String password = "Control123!";
    String accountToBeCreate = "accountTest1f";
    String oportunityName = "oportunityTest1f";
    String oportunityCloseData = "11/08/2015";
    String oportunityStage = "Prospecting";
    String accountToSetInOportunity = "accountTest1f";
    @Test
    public void startRun () throws Exception{

        //Preconditions
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLoginButton()
                .setUserNameText(username)
                .setPasswordText(password);
        MainWindow mainWindow = loginPage.clickLoginButton();
        MenuBar menuBar = mainWindow.goToMenuBar();
        AccountTab accountTab = menuBar.goToUserAccountTab();
        AccountForm accountForm = accountTab.goToAccountForm()
                .setAccountName(accountToBeCreate)
                .clickCreateAccountButton();
        //Steps
        OportunitiesTab oportunitiesTab = menuBar.goToOportunitiesTab();
        OportunitiesForm oportunitiesForm = oportunitiesTab.clickNewOportunitiesForm()
                .setOportunityName(oportunityName)
                .setCloseData(oportunityCloseData)
                .setStage(oportunityStage)
                .setAccount(accountToSetInOportunity);
        OportunityObject oportunityObject = oportunitiesForm.clickSaveOportunitiesButton();

        //Expected Result
        Assert.assertEquals(oportunityObject.getOportunityName(), oportunityName);
        Assert.assertEquals(oportunityObject.getOportunityCloseDate(), oportunityCloseData);
        Assert.assertEquals(oportunityObject.getOportunityStage(), oportunityStage);
        Assert.assertEquals(oportunityObject.getOportunityAccount(), accountToSetInOportunity);

        //#### Postcondition [Here I found a bug, it is not possible to delete the created account and Oportunity,
        //#### I double checked it tring manually and confirmed that it is not possible to delete the objects:Account and oportunity]
        //accountForm.deleteAccount(accountToBeCreate);
        //oportunityObject.deleteOportunity(oportunityName);



    }
    @AfterClass
    public void tearDown() {

    }

}
