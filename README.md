# bpmplatform
BPM Platform
OVERVIEW
This document describes the BPM Platform, which will allow for users to document their business process flows and calculate key performance indicators (KPIs).
REQUIREMENTS
User Profile
Allow for users to sign in and sign up for an account to access the platform. 
The following fields will be required for registration:
First Name
Last Name
Company Name
Email
Phone Number
Password
Confirm Password
Users will login with email and password.
Business Process
Allow for users to create new business processes, the business processes will include:
Diagramming Library
Use the DrawIO library
https://github.com/jgraph/drawio
Calculation Values
Described below
Calculation Inputs
Described below
Users will be able to create multiple business processes, each one will have its own respective components (as mentioned above). 
Calculation values will be toggleable to hide/show the value. 
Calculations
Allow for users to calculate the following values for each business process:
TBD
Allow users to add values for:
Cost Spend
Will be key value pairs, used for calculations
Time Spend
Will be key value pairs, used for calculations
Revenue
Will be key value pairs, used for calculations
Admin Users
Allow for an admin user to login, and view a complete dashboard of all of the signed up users.
Allow the admin user to go impersonate to view the users account. They can do all of the actions the user would do on their own account, and changes made will be as if the user themselves did it.
Allow admin to add users. Will send the user a password via email. 
Allow users to active/deactivate users. Active users will be able to login, deactivated users will not be able to access the platform. 
Push Pop Up Notification
Allow for admin users to create a pop up notification that will appear to users.
Allow admin users to create the content of the pop up notification with a WYSIWYG editor. 
Allow admins to keep track of which users viewed the push notification.
The push notification will only appear once in the bottom right corner.
1. mvn clean
2. mvn clean install
3. Go to the target folder
4. java -jar demo-0.0.1-SNAPSHOT.ja

- http://localhost:8080/registration
- http://localhost:8080/login

