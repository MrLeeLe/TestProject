Feature: Upload file
  I want to use this feature to upload files to the system

  Scenario: UI of upload feature shows properly
   Given User access to upload page
    Then Upload page displays properly
    
  Scenario Outline: User is able to upload file less than 196.45MB successfully
    When User access to upload page
    When User try to upload file '<filename>' and accept terms of service
    Then File is upload successfully
    
    Examples: 
      | filename|
      | test_txt.txt|
      | test_pdf.pdf|
      | test_doc.doc|
      | test_mp3.mp3|
      | test_mp4.mp4|
      #Follow following link to create other file extension
      # https://support.microsoft.com/vi-vn/windows/%C4%91u%C3%B4i-t%C3%AAn-t%E1%BB%87p-ph%E1%BB%95-bi%E1%BA%BFn-trong-windows-da4a4430-8e76-89c5-59f7-1cdbbc75cb01

 Scenario Outline: User is not allowed to upload file greater than 196.45MB
    When User access to upload page
    When User try to upload file '<filename>' and accept terms of service
    Then Upload error message shows
    
    Examples: 
      | filename|
      | test_txtgreater196.txt|
      | test_pdfgreater196.pdf|
      | test_docgreater196.doc|
      | test_mp3greater196.mp3|
      | test_mp4greater196.mp4|
      #File size is huge so that they are not pushed to Git
      #Please follow link to create your own file and put in 'testdata' folder
      #Follow following link to create other file extension
      # https://support.microsoft.com/vi-vn/windows/%C4%91u%C3%B4i-t%C3%AAn-t%E1%BB%87p-ph%E1%BB%95-bi%E1%BA%BFn-trong-windows-da4a4430-8e76-89c5-59f7-1cdbbc75cb01
      
   Scenario Outline: User is not allowed to upload file if terms of service is not checked
    When User access to upload page
    When User try to upload file '<filename>' without accepting terms of service
    Then Upload error message shows
    
    Examples: 
      | filename|
      | test_txt.txt|
      | test_pdf.pdf|
      
    
    Scenario: Verify that error message will show when user try to upload no file
   		Given User access to upload page
   		When User upload no file
    	Then Upload error message shows
      
