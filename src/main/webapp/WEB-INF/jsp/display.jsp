<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">           
  <table class="table table-dark">
    <thead>
      <tr>
        <th>Employee Id</th>
        <th>Employee Name</th>
        <th>Employee Salary</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${emp.id }</td>
        <td>${emp.name }</td>
        <td>${emp.sal }</td>
      </tr>
     
    </tbody>
  </table>
</div>

</body>
</html>
