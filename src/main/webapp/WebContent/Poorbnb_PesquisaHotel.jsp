<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">


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
		<div class="col-md-4">
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
		<div class="col-sm-4">
			<p></p>
			<div class="ml-auto p-2">
				<div class="card">
					<article class="card-body">
						<h5 class="card-title text-center mb-4 mt-1">São paulo :
							1.033 acomodações encontradas</h5>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend"></div>
								<!-- Card do hotel-->
								<div class="container">
									<div class="p-2 bd-highlight">
										<div class="card w-100 border-warning shadow">
											<div class="card-body ">
												<img class="card-img-top"
													src="./resources/imagem/tumb_1.png"
													alt="Imagem de capa do card">
												<div class="card-body">

													<b>Hotel Bahia do Sol</b>
													<p class="card-text">Pelourinho, Salvador - BA</p>
													<b><FONT COLOR="#B22222">R$ 90,00</FONT> </b> <small
														class="text-muted">a diária</small>
													<p></p>
													<div
														class="d-flex justify-content-between align-items-center">
														<div class="btn-group">
															<button type="button" class="btn btn-sm btn-warning">Ver
																este hotel</button>

														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Fim card do hotel -->
							</div>
						</div>
					</article>
				</div>
			</div>
		</div>
	</div>
</body>
</html>