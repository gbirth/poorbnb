<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">


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

	<!-- Busca hotel -->

	<p></p>
	<section class="d-flex justify-content-center">
		<div class="container">
			<div class="p-2 bd-highlight">
				<div class="card w-100 border-warning shadow">
					<div class="card-body ">
						<h5 class="card-title text-warning">Buscar hotel</h5>
						<form>
							<table>
								<tr>
									<td><font>Local </font></td>
									<td><input type="text" name="LOCAL" /></td>
									<td><FONT COLOR="#ffffff">__</FONT></td>
									<td><font>Check-in</font></td>
									<td><input type="date" pattern="dd/mm/yyyy" /></td>
									<td><FONT COLOR="#ffffff">___</FONT></td>
									<td><font>Check-out</font></td>
									<td><input type="date" pattern="dd/mm/yyyy" /></td>
								</tr>
								<tr>
									<td><FONT COLOR="#ffffff">___</FONT></td>
								</tr>
								<tr>
									<td><font>Crianças</font> <font color="#DAA520">(0-2
											anos)</font></td>
									<td><input type="number" min="0"></td>
									<td><FONT COLOR="#ffffff">___</FONT></td>
									<td><font>Adultos</font></td>
									<td><input type="number" min="0"></td>
									<td><FONT COLOR="#ffffff">____</FONT></td>
									<td><FONT COLOR="#ffffff">___________</FONT></td>
									<td><button type="button" class="btn btn-warning btn-lg">Buscar</button></td>
								</tr>


							</table>
						</form>
					</div>
				</div>
			</div>
		</div>

	</section>

	<!-- Fim busca hotel -->

	<!--Titulo-->

	<!-- Fim titulo -->

	<!-- Baixo -->
	<div class="album py-5 ">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">

						<img class="card-img-top" src="./resources/imagem/tumb_1.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Hotel Bahia do Sol</b>
							<p class="card-text">Pelourinho, Salvador - BA</p>
							<b><FONT COLOR="#B22222">R$ 90,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>

								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_2.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Pousada Gia-monte</b>
							<p class="card-text">Morro Grande, Ibiúna - SP</p>
							<b><FONT COLOR="#B22222">R$ 115,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_3.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Rio way hostel</b>
							<p class="card-text">Barra da Tijuca, Rio de Janeiro - RJ</p>
							<b><FONT COLOR="#B22222">R$ 110,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_4.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Hotel Deise Prado</b>
							<p class="card-text">Teresina, Piaui - PI</p>
							<b><FONT COLOR="#B22222">R$ 89,90</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_5.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Econo Lodge</b>
							<p class="card-text">Goiânia, Goiás - GO</p>
							<b><FONT COLOR="#B22222">R$ 95,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_6.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Hostel Saaris</b>
							<p class="card-text">Bela Vista, São Paulo -SP</p>
							<b><FONT COLOR="#B22222">R$ 150,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_7.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Água branca hotel</b>
							<p class="card-text">Rio Branco, Acre - AC</p>
							<b><FONT COLOR="#B22222">R$ 75,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_8.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Serra Negra hostel</b>
							<p class="card-text">Belo Horizonte, Minas Gerais - MG</p>
							<b><FONT COLOR="#B22222">R$ 65,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src="./resources/imagem/tumb_9.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<b>Fort mar hotel</b>
							<p class="card-text">Fortaleza, Ceará - CE</p>
							<b><FONT COLOR="#B22222">R$ 160,00</FONT> </b> <small
								class="text-muted">a diária</small>
							<p></p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-warning">Ver
										este hotel</button>
								</div>
								<small class="text-muted">Veja mais</small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Fim Baixo -->
	<!-- Footer inicio -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-white">
		<p class="text-center"></p>
	</nav>
</body>
</html>