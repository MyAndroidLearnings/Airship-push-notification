# Airship Push Notification Kotlin

### Introduction:

This project is created in the intention to understand the Airship PushNotification and make it as
readily usable component to integrate it with any projects

----------------------------------------------------------------------------------------------------

### Installation:

In Our Project  Click Tools -> Firebase   -	Assistant Sidebar will open, in that click Cloud
        Messaging and Select Set up Firebase Cloud Messaging.

2.	Set up Firebase Cloud Messaging  -> click Connect to Firebase, it will prompt below window for
        project creation in firebase.

3.	If you login firebase for the first time it will shown as per screenshot 0.1.
![alt text](https://i.postimg.cc/CMjtrXTN/screenshot-0-1.png)

4.	Login to your firebase configuration Email. After login to mail it will ask for firebase trust.
        Click trust it will go to another window as per screenshot 0.2.
![alt text](https://i.postimg.cc/y8NbdNJQ/screenshot-0-2.png)

5.	As per above click firebase it will direct into Firebase home page.

6.	In firebase home page click Go to console, we can see the list of projects already created in
        firebase and we can able to create new project in the console window as per screenshot 0.4.
![alt text](https://i.postimg.cc/SRqZpQFG/screenshot-0-4.png)

7.	If you already logged in your firebase account it will show as per screenshot 0.5.
![alt text](https://i.postimg.cc/3wsSnCtV/screenshot-0-5.png)

8.	In screenshot 0.5 window click connect to Firebase, it will create our project in firebase.
        Then click Add FCM to your app. It will prompt dialog windown as per screenshot 0.6.
![alt text](https://i.postimg.cc/nrk3V8nf/screenshot-0-6.png)

9.	Click Accept Changes it will automatically add the required dependencies in gradle file.

10.	We can see our project has created  in firebase Console page as per screenshot 0.7.
![alt text](https://i.postimg.cc/HkPP7CXp/screenshot-0-7.png)

11.	Click out project in Firebase it will go to project overview page as per screenshot 0.8.
![alt text](https://i.postimg.cc/MT1s4M4T/screenshot-0-8.png)

12.	Once done with the above steps, check inside of our project  app folder google-services.json
        file will be there, if we create project using android studio tools it will automatically
        places the file inside of app folder.

13. Firebase installation done, start with Airship installation Go to airship.com site and login
        with Email and create our project.

14. Once Project created it will start with Quick start guide.In there Add Channel Android/iOS.

15. In setup push provider give Api key from Firebase and our project Package name and click save
        credentials, and click skip it will navigate to overview page.

16. Get Api key from Firebase – in our project overview page in firebase near by project overview
        click settings icon -> project settings.

17. In settings page click cloud messaging tab copy legacy server key and paste this key in airship
        setup push provide api key field. Also make copy the Sender Id from the cloud messaging tab.
         This sender id key will be use for airshipconfig.properties file.

18. Add below in our build.gradle file for airship.

```
implementation "com.urbanairship.android:urbanairship-fcm:11.0.1"

```

----------------------------------------------------------------------------------------------------

### Configuration:

1. Add the below metadata for Airship notification

```
<meta-data
   android:name="com.urbanairship.autopilot"
   android:value="com.urbanairship.Autopilot" />
```

   Add the below in AndroidManifest file for Internet Permission
    
```
<uses-permission android:name="android.permission.INTERNET"/>
```

2. Create assets folder inside app -> src -> main folder.

3. Inside assets folder create airshipconfig.properties file(File - > New -> Resource Bundle ->
       airshipconfig)
       
Add below content inside airshipconfig file:

```
    developmentAppKey = EnterProjectAppKey
    developmentAppSecret = EnterProjectAppSecretKey

    productionAppKey = EnterProjectAppKey
    productionAppSecret = EnterProjectAppSecretKey

    # Toggles between the development and production app credentials
    # Before submitting your application to an app store set to true
    inProduction = false

    # LogLevel is "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR" or "ASSERT"
    developmentLogLevel = DEBUG
    productionLogLevel = ERROR

    # FCM/GCM Sender ID
    fcmSenderId = EnterFCMSenderId

    # Notification customization
    notificationIcon = ic_notification
    notificationAccentColor = #ff0000

    # Optional, set the default notification channel
    notificationChannel = customChannel
```

4. Go to Airship -> our project -> settings ->APIs & Integrations.

    In APIs & Integrations page we need to copy that appkey, paste it in developmentAppKey and
        productionAppKey in the airshipconfig.properties file.

    Copy AppSectrey key and paste it in developmentAppSecret and productionAppSecret in the
        airshipconfig.properties file.

    Copy SenderId in firebase -> project settings -> cloud messaging. Need to paste this copied
        senderId in fcmSenderId  field in the airshipconfig.properties file.

----------------------------------------------------------------------------------------------------

### Coding Part:

1. Enable the user notification in our project by using the below code.

```
UAirship.shared().pushManager.userNotificationsEnabled = true
```

2. If we want to know our device’s channel id use the below code.

```
var channelId = UAirship.shared().pushManager.channelId
```

----------------------------------------------------------------------------------------------------

#### Test Flow:

1. 	Now go to airship -> our project ->  click create.

2. In message creation window click message -> All Users (if want to send specific click ->
        Target Specific users) -> Push Notification -> click add content -> add content of
        push notification -> click Delivery -> send Now -> Review & Send -> Send Message.

    You will get Push notification.