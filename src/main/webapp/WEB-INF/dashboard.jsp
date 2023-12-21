<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
crossorigin="anonymous">
<link rel="stylesheet" href="css/default.css">
<title>Dashboard</title>
</head>
<body>
    <!-- message -->
    <div th:if  test="${not empty param.msg}">
        <div class="alert alert-danger bg-transparent border-0 text-danger"><p class="text-center fs-4 text-success">${msg}</p></div>
    </div>
    <a href="/logout">Logout</a>
	<h1>Welcome:  ${user.first_name}</h1>
	<h1>Email : ${user.email}</h1>
    <div class="text-warning">  
        <a href="/" class="btn btn-sm bg-light btn-lg" role="button">Profile Update</a>
    </div>
     
</body>
</html>