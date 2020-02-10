function checkForm(f){

    const REGISTRATION_NUMBER_REGEX = /^[\d]{4}\s?[A-z]{2}-?\d$/;

    let stateNumber = document.getElementById('stateNumber').value;
    let numberOfSeats = parseInt(document.getElementById('numberOfSeats').value);

    let stateNumberResult = REGISTRATION_NUMBER_REGEX.test(stateNumber);
    let numberOfSeatsResult = (numberOfSeats <= 30 && numberOfSeats > 0);

    if (stateNumberResult && numberOfSeatsResult) {
        return true;
    } else {
        alert('Check correctness fields')
      return false;
    }
};