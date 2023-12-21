<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
    crossorigin="anonymous">
    <link rel="stylesheet" href="css/default.css">
    <title>OTP Verification</title>
</head>
<body class="d-flex align-items-center justify-content-center">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" 
    crossorigin="anonymous"></script>
    
    <div class="card login-form-card col-3 bg-transparent border-0">
        <h1 class="from-header card-title mb-3">
            <i class="fa fa-edit"></i>OTP Verification
        </h1>

        <form action="/otpVerification" class="Verification-form" method="post"> 

                <div class="form-group col">
                    <input type="text" name="otp" class="form-control form-control-lg" placeholder="Enter OTP">
                </div>

            <div>

            <div class="form-group col">
               <button class="btn btn-lg">Verify</button>
            </div>

        </form>

        <p class="card-text text-dark my-2">
            Already have an account? <span class="ms-2 text-body-tertiary">
                <a href="/" class="btn bt-sm text-warning">Sign In</a>
            </span>
        </p>

        <small class="text-warning">  
            <a href="/" class="btn btn-sm bg-light" role="button">Back</a>
        </small>

     <!-- error message -->
     <div th:if  test="${not empty param.msg}">
        <div class="alert alert-danger bg-transparent border-0 text-danger"><p class="text-center fs-4 text-success">${msg}</p></div>
    </div>
    </div>


</body>
</html>