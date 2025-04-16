# jsp-servlet-healthcare-management-system
servlet healthcare management system

# Project Name : - healthcare-management-system.
Project Overview
The Core Java JSP-SERVLET healthcare Management Project is a basic Java application that demonstrates a Appointment booking management system. It utilizes object-oriented programming principles and simulates the interactions between persons, doctors, hospitals , and appointments.

# Features
Manage  for persons and doctors.
<ul>
  <li>Manage for persons and doctors.</li>
  <li>Simulate appointment assignment.</li>
  <li>hospitals and appointment management using Java models.</li>
  <li>Simple and intuitive structure for learning and demonstration.</li>
</ul>

# Installation and Setup
Prerequisites
<ul>
  <li>Java Development Kit (JDK) 21.</li>
  <li>An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.</li>
  <li>Git (optional, for version control).</li>
</ul>

# Steps
Clone the repository:
Navigate to the project directory:
<ul>
  <li>cd jsp-servlet-healthcare-management-system</li>
  <li>Open the project in your preferred IDE.</li>
  <li>Compile and run the application:</li>
  <li>Locate Main.java.</li>
  <li>Run the file to start the application.</li>
</ul>

# POJO (Plain Old Java Objects)
<ul>
  <li>person - (persinId, fname, lname, age, gender, mobile, alternateMobile, address)</li>
  <li>doctor -(doctorId,fname,lname,age,gender,contactNo,speciality)</li>
  <li>hospital-(hopitalId,name,emailId,address,contactno)</li>
  <li>department-(deptId,deptname)</li>
  <li>appointment-(appointmentId,personId,doctorId,hospitalId)</li>
  <li>prescription-(prescriptionId,prescriptionDetails,personId)</li>
  <li>bill-(billId,bill,totalBill)</li>
</ul>

#  Class Diagram
```mermaid
---
title: healthcare management system
---
classDiagram

 note " This is generally appointment booking for health services"

 class Person
 Person : +int personId
 Person : +String firstname
 Person : +String lastName
 Person : +int age
 Person : +String gender
 Person : +Long contactNo
 Person : +Long alternateMobile
 Person : +String address

class Person{
 +createPerson()
 +displayPerson()
}

 

Doctor: +int doctorId
Doctor: +String firstName
Doctor: +String lastName
Doctor: +int age
Doctor: +String gender
Doctor: +String contactNo
Doctor: +String speciality
Doctor: +int experience

class Doctor{
 +createDoctor()
 +displayDoctor()
}


Hospital: +int hospitalId
Hospital: +String hospitalName
Hospital: +String address
Hospital: +Long contactNo
Hospital: +String emailId

class Hospital{
+createHospital()
+displayHospital()
}

Department: +int deptId
Department: +String deptName
Department: +doctorId
Department: +hosptitalId

class Department{
+createDepartment()
+displayDepartment()
}

Hospital <-- Department : Association
Doctor  <-- Department  : Assocciation

Appointment: +int appointmentId
Appointment: +int personId
Appointment: +int doctorId
Appointment: +int hospitalId
Appointment: +int deptId

class Appointment{
+createAppointment()
+displayAppointment()

}


Appointment --> Person : Association
Appointment --> Doctor : Association
Appointment --> Hospital : Association
Appointment --> Department : Association

Prescription : +int prescriptionId
Prescription : +String prescriptionDetails
Prescription : +int personId

class Prescription{
+createPrescription()
+displayPrescription()
}

Prescription --> Person : Association

Billing : +int billId
Billing : +int bill
Billing : +int totalBill
Billing : +int personId

class Billing{
+createBilling()
+displayBilling()
}

Billing --> Person : Association

```
