issue found in the contact form (I need to supose some requirements):

- email format validation doesn't exist (in frontend at least);
- code number format validation doesn't exist (in frontend at leats);
- phone format validation doesn't exist (in frontend at leats);
- after open end close the form a couple times, a error message (Jquery + Umbraco Forms) could be shown;
- Answer type selector allows remove a selected value even this selector been a required field;

improvements suggest:
- use masks or placeholder on fields that need any kind of validation