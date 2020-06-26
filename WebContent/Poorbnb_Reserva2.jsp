<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style>
.estrelas input[type=radio] {
	display: none;
}

.estrelas label i.fa:before {
	content: '\f005';
	color: #FC0;
}

.estrelas input[type=radio]:checked ~ label i.fa:before {
	color: #CCC;
}
</style>

</head>
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

	<!-- Barra pesquisa -->
	<div class="row">
		<div class="col">
			<p></p>
			<div class="container d-flex justify-content-left">

				<div class="card">
					<article class="card-body">
						<h5 class="card-title text-center mb-4 mt-1">Pesquisa</h5>
						<form>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fa fa-map-marker" aria-hidden="true"></i> </span>
									</div>
									<input class="form-control" placeholder="Local" type="text">
								</div>
								<!-- local// -->

								<p></p>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">Check-in </span>
										</div>
										<input class="form-control" type="date">
									</div>
									<!-- Check-in// -->

									<p></p>
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> Check-out </span>
											</div>
											<input class="form-control" placeholder="Check out"
												type="date">
										</div>
										<!-- Check-out// -->
										<p></p>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="fa fa-user"></i>
													</span>
												</div>
												<input class="form-control" placeholder="Crianças"
													type="number">
											</div>
											<!-- Crianças// -->
										</div>

										<p></p>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="fa fa-user"></i>
													</span>
												</div>
												<input class="form-control" placeholder="Adultos"
													type="number">
											</div>
											<!-- Adultos// -->
										</div>
									</div>
								</div>
							</div>
						</form>
					</article>
				</div>
			</div>
		</div>

		<!-- Hoteis -->
		<div class="col-10 justify-content-left">
			<p></p>
			<div class="ml-auto p-2">
				<div class="card">
					<article class="card-body">

						<h3 class="card-title text-left mb-4 mt-1">Insira seus dados
						</h3>
						<div class="row">
							<FONT> <i class="fa fa-sign-in" aria-hidden="true"></i>
								Faça login para reservar com seus dados salvos ou cadastre-se
								para administrar suas reservas de onde estiver!
							</FONT>
						</div>
						<p></p>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i>
											</span>
										</div>
										<input class="form-control" placeholder="Nome" type="text">
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i>
											</span>
										</div>
										<input class="form-control" placeholder="Sobrenome"
											type="text">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="fa fa-envelope" aria-hidden="true"></i>
											</span>
										</div>
										<input class="form-control" placeholder="E-mail" type="email">
									</div>
								</div>
								<div class="col">
									<font></font>
								</div>
							</div>
							<div class="col-md-4">
								<font>A confirmação será enviada para este e-mail</font>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="fa fa-envelope" aria-hidden="true"></i>
											</span>
										</div>
										<input class="form-control" placeholder="Confirme seu e-mail"
											type="email">
									</div>
								</div>
							</div>
							</div>
							<hr class="featurette-divider">
							<div class="row">
							<h5 class="card-title text-left mb-4 mt-1">Fazer uma pergunta
						</h5>
						</div>
						<div class="row">
						<div class="col-md-6">
						<p style="text-align:justif;">Por favor, caso desejar, escreva seus pedidos e compartilharemos com a acomodação.
Os pedidos especiais não podem ser garantidos - mas a acomodação irá se esforçar para atender ao seu pedido.
Você sempre pode fazer um pedido especial após concluir sua reserva!</p>
</div>
</div>
<div class="row">
<div class="col-md-6">
						<textarea cols="50"> </textarea>
</div>
</div>
<div class="row">
<div class="col">
<div class="alert alert-warning" role="alert">
  As demais dúvidas e os próximos passos da sua reserva serão tratados diretamente com os reponsáveis pela acomodação. Os mesmos entrarão em contato com você em breve.
</div>
</div>
</div>
<div class="row">
<div class="col-md-3 offset-md-10">
<button type="button" class="btn btn-warning">Finalizar</button>
</div>
</div>
						
					</article>
				</div>

			</div>
		</div>
	</div>

</body>
</html>