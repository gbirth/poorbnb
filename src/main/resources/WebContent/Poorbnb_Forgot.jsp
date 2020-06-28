<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<style>
body {
	background-position: center;
	background-color: #eee;
	background-repeat: no-repeat;
	background-size: cover;
	color: #505050;
	font-family: "Rubik", Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.5;
	text-transform: none
}

.forgot {
	background-color: #fff;
	padding: 12px;
	border: 1px solid #dfdfdf
}

.padding-bottom-3x {
	padding-bottom: 72px !important
}

.card-footer {
	background-color: #fff
}

.btn {
	font-size: 13px
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #76b7e9;
	outline: 0;
	box-shadow: 0 0 0 0px #28a745
}
</style>
<body background="./resources/imagem/bg.png">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light  shadow">
		<a class="navbar-brand" href="#"> <img
			src="./resources/imagem/logo.png" width="200" height="50" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#conteudoNavbarSuportado"
			aria-controls="conteudoNavbarSuportado" aria-expanded="false"
			aria-label="Alterna navegação">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Página
						inicial <span class="sr-only">(página atual)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Sobre</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Anuncie
						seu hotel</a></li>

			</ul>
			<form class="form-inline my-2 my-lg-0">

				<div class="btn-group " role="group" aria-label="Exemplo básico">
					<button type="button" class="btn btn-warning">Cadastrar</button>
					<button type="button" class="btn btn-warning">Entrar</button>
				</div>
			</form>
		</div>
	</nav>


	<!-- Fim navbar -->
	<!-- Forgot Password -->

	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h2>Esqueceu sua senha?</h2>
					<p>Mude sua senha seguindo os três seguintes passos.</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>Digite
							seu endereço de email.</li>
						<li><span class="text-primary text-medium">2. </span>Nosso
							sistema vai mandar para você um link para redefinir sua senha.</li>
						<li><span class="text-primary text-medium">3. </span>Use o
							link para resetar sua senha.</li>
					</ol>
				</div>
				<form class="card mt-4">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">Digite seu email</label> <input
								class="form-control" type="text" id="email-for-pass" required=""><small
								class="form-text text-muted">Use o seu email cadastrado
								no Poorbnb.</small>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-warning" type="submit">Gerar nova
							senha</button>
						<button class="btn btn-warning" type="submit">Voltar para
							o login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Forgot Password -->

	</nav>
</body>
</html>