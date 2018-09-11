IF we want control the browser, we need to download geckodriver  https://github.com/mozilla/geckodriver/releases  - For Chrome
and
http://chromedriver.chromium.org/ for Chrome
file geckodriver remove in package system32. C/Windows/system32

Libraries that are needed: selenium-java 3.13.0 ; testng 6.14.3 ; commons-lang3 3.8.

-The project contains a Test and four PageObgects;
-GooglePage, GoogleSearchPage and NextGooglePage - describe the elements on the relevant pages
and contain the methods which we use in test;
-BasePage - contains base methods wich we use in every PageObgect;

We have file .gitignore. Files from this package will not be puch in Git.

The Test runs in ExamTest