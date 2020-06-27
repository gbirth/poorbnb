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

						<h3 class="card-title text-left mb-4 mt-1">TRYP by Wyndham
							Sao Paulo Paraiso <button type="button" class="btn btn-warning">Reservar agora</button></h3>

						<h6 class="card-title text-left mb-4 mt-1">
							<i class="fa fa-map-marker" aria-hidden="true"></i> Afonso de
							Freitas 148, Paraiso, Vila Mariana, São Paulo, CEP 04006-050,
							Brasil
						</h6>

						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend"></div>

								<!-- Carousel -->
								<p></p>
								<div class="row ">

									<div id="carouselExampleControls" class="carousel slide"
										data-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active">
												<img class="d-block w-50"
													src="./resources/imagem/tumb_1.png" alt="First slide">
											</div>
											<div class="carousel-item">
												<img class="d-block w-50"
													src="./resources/imagem/tumb_2.png" alt="Second slide">
											</div>
											<div class="carousel-item">
												<img class="d-block w-50"
													src="./resources/imagem/tumb_3.png" alt="Third slide">
											</div>
										</div>
										<a class="carousel-control-prev"
											href="#carouselExampleControls" role="button"
											data-slide="prev"> <span
											class="carousel-control-prev-icon" aria-hidden="true"></span>
											<span class="sr-only">Previous</span>
										</a> <a class="carousel-control-next"
											href="#carouselExampleControls" role="button"
											data-slide="next"> <span
											class="carousel-control-next-icon" aria-hidden="true"></span>
											<span class="sr-only">Next</span>

										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- Fim carousel -->
						<!-- Descrição -->
						<p></p>
						<div class="row">
							<p class="font-weight-bold">Descrição</p>
						</div>
						<p class="font-weight-normal">Lorem ipsum metus per elementum
							sit venenatis vivamus sed imperdiet, sem accumsan velit purus
							commodo congue feugiat sit, cras arcu gravida netus tortor
							viverra lectus hac. nisl etiam elit urna molestie fermentum
							lobortis sodales a eget, quisque convallis eleifend morbi quisque
							nibh cursus erat nulla, habitant praesent turpis donec praesent
							posuere aptent justo. dictumst faucibus sollicitudin hac platea
							hac aliquam auctor nunc himenaeos congue, dictumst aptent
							fermentum donec ullamcorper conubia viverra consequat hac.
							pretium rutrum sociosqu aptent pellentesque etiam pretium neque,
							et eleifend purus dapibus curae mi, ut dapibus libero congue
							donec fermentum. Amet eros ut habitasse dictum lectus semper vel
							aenean, libero risus diam pellentesque suscipit habitasse augue
							condimentum, eget ad integer est quisque tortor habitant.
							vehicula eget nec commodo litora mollis sapien metus, tempus
							potenti rutrum quisque hac etiam lacus, senectus nec ligula
							consequat primis eros. orci eleifend integer praesent diam
							suspendisse vulputate class nisi elit hac nullam pharetra aptent
							non, convallis odio nulla tempor orci venenatis ut habitasse ac
							bibendum dictum nibh. arcu dictumst nullam fermentum auctor urna
							ultricies eros, donec blandit ullamcorper phasellus aliquam
							aenean, fames in metus fusce feugiat tempus.</p>
						<!-- Descrição -->

						<!-- Comodidades -->
						<div class="row">
							<p class="font-weight-bold">Principais comodidades</p>
						</div>
						<div class="row">
							<ul class="list-group list-group-horizontal-xl">
								<li class="list-group-item"><i class="fa fa-wifi"
									aria-hidden="true"></i> Wi-fi</li>
								<li class="list-group-item"><i class="fa fa-car"
									aria-hidden="true"></i> Estacionamento</li>
								<li class="list-group-item"><i class="fa fa-paw"
									aria-hidden="true"></i> Aceita pets</li>
							</ul>

						</div>
						<!-- Comodidades -->

						<!-- Disponibilidade -->
						<p></p>
						<div class="row">
							<p class="font-weight-bold">Disponibilidade</p>
						</div>
						<div class="row">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">Tipo de acomodação</th>
										<th scope="col">Acomoda</th>
										<th scope="col">Preço</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row"><p>Standard</p>
											<p>
												1 cama de casal <i class="fa fa-bed" aria-hidden="true"></i>
											</p></th>
										<td>2 pessoas</td>
										<td>R$100,00</td>
									</tr>
									<tr>
										<th scope="row"><p>Standard 2</p>
											<p>
												1 cama de casal <i class="fa fa-bed" aria-hidden="true"></i>
											</p>
											<p>
												1 cama de solteiro <i class="fa fa-bed" aria-hidden="true"></i>
											</p></th>
										<td>3 pessoas</td>
										<td>R$150,00</td>
									</tr>

								</tbody>
							</table>
						</div>
						<!--Google Maps-->
						<div class="row">
							<p class="font-weight-bold">Pormenores</p>
							<FONT>Por favor, observe que o serviço de quarto está
								disponível diariamente até as 22h30. De acordo com a Lei Federal
								Brasileira 8.069/1990, os menores de 18 anos não podem fazer o
								check-in em hotéis, a menos que estejam acompanhados pelos pais
								ou responsável autorizado. Se o menor estiver acompanhado por um
								adulto que não seja um dos pais, é necessário apresentar uma
								autorização por escrito para que o menor possa fazer o check-in
								no hotel. Esta autorização deverá ser reconhecida em cartório,
								assinada por ambos os pais e apresentada juntamente com as
								cópias autenticadas dos documentos de identidade dos pais. Os
								menores de 18 anos de idade devem apresentar um documento de
								identidade válido com foto que comprove sua identidade e a de
								seus pais. Esse documento deve ser apresentado mesmo que o menor
								esteja na companhia dos pais. Em resposta ao Coronavírus
								(COVID-19), medidas adicionais de segurança e higiene estão
								sendo adotadas nesta acomodação.</FONT>
								<button type="button" class="btn btn-warning">Reservar agora</button>
						</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>