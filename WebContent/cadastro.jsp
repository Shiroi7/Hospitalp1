<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>

<section class="container">
	<form action="cadastrar" method="POST">

		<label>Nome: <input type="text" name="nome"
			placeholder="Favor inserir o nome do funcionário" required />
		</label> <label>Login: <input type="text" name='login'
			placeholder='Digite um login' required />
		</label> <label>Senha: <input type='password' name='senha'
			placeholder='Digite a senha.' required />
		</label> <input type='radio' class="radiobut" name='tipoFunc' value='Medico'> Medico<br>
		<input type='radio'class="radiobut" name='tipoFunc' value='Secretaria'>
		Secretaria <br>

		<button>Cadastrar</button>
	</form>
</section>


</body>
</html>