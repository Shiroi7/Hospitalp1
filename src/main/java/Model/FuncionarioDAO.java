package Model;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

	private static List<Funcionario> FUNCIONARIOS = new ArrayList<Funcionario>();

	private static List<Paciente> PACIENTES = new ArrayList<Paciente>();

	static {
		try {
			// Secretarias
			FUNCIONARIOS.add(new Funcionario("Jose", "Jose", "123", "Secretaria", "", ""));
			FUNCIONARIOS.add(new Funcionario("Marta", "Marta", "123", "Secretaria", "", ""));

			// Medicos
			FUNCIONARIOS.add(new Funcionario("Beto" /* nome */, "BetoL"/* login */, "123"/* senha */,
					"Medico"/* função */, "Testson"/* paciente */, "30/09/2019 13:20"/* agenda */));
			FUNCIONARIOS.add(new Funcionario("Barbara", "Barbara", "123", "Medico", "Testson", "30/09/2019 13:20"));
			FUNCIONARIOS.add(new Funcionario("Maria", "Maria", "123", "Medico", "Pedrinho", "30/09/2019 10:20"));
			FUNCIONARIOS.add(new Funcionario("Paulo", "Paulo", "123", "Medico", "Mariazinha", "29/09/2019 07:20"));

			// Pacientes
			PACIENTES.add(new Paciente("Pedrinho" /* nome */, "1234-1234"/* telefone */, "Dor de cabeça"/* Sintoma */,
					""/* Prontuario */));
			PACIENTES.add(new Paciente("Mariazinha", "1234-4321", "Braço com formigamento", ""));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastrarSecretaria(String nome, String login, String senha) {
		System.out.println(login + "Oi eu sou um login \n" + senha + "Oi eu sou uma senha \n" + nome);
		FUNCIONARIOS.add(new Funcionario(nome, login, senha, "Secretaria"));

	}

	public void cadastrarMedico(String nome, String login, String senha) {
		System.out.println(login + senha + nome);
		FUNCIONARIOS.add(new Funcionario(nome, login, senha, "Medico"));

	}

	public void cadastrarPaciente(String nome, String telefone, String sintomas) {
		System.out.println(nome + telefone + sintomas);
		PACIENTES.add(new Paciente(nome, telefone, sintomas, ""));

	}

	public void alterarProntuario(String prontuario) {

	}
	

	public void agendarConsulta(String medico, String paciente, String horario) {

		for (Funcionario f : FUNCIONARIOS)
			if (f.getLogin().equals(medico)) {
				f.setPaciente(paciente);
				f.setHorario(horario);
			}

	}

	public ArrayList<String> consultarPacientes(String nomeMedico) {

		ArrayList<String> agendamento = new ArrayList<String>();

		for (Funcionario f : FUNCIONARIOS)
			if (f.getLogin().equals(nomeMedico)) {
				if (f.paciente != null && f.paciente.size() > 0) {
					agendamento = f.paciente;
				}else {
					agendamento.add("Sem pacientes.");
				}
			}
		return agendamento;
	}

	public ArrayList<String> consultarHorarios(String nomeMedico) {

		ArrayList<String> agendamento = new ArrayList<String>();

		for (Funcionario f : FUNCIONARIOS)
			if (f.getLogin().equals(nomeMedico)) {
				if (f.horario != null && f.horario.size() > 0) {
					agendamento = f.horario;
				}else {
					agendamento.add("Sem consultas.");
				}
			}
		return agendamento;
	}

	public Funcionario verificarLogin(String login, String senha) {
		Funcionario funcionario = null;
		System.out.println(senha + login);
		for (Funcionario f : FUNCIONARIOS) {
			System.out.println("Login enviado :" + login + " Login foreach " + f.getLogin());
			System.out.println("Senha enviado :" + senha + " Senha foreach " + f.getSenha());
			String logins = f.getLogin();
			String senhas = f.getSenha();

			if (logins.equals(login) && senhas.equals(senha)) {
				funcionario = f;
				System.out.println("Login deu certo");

			}
		}
		if (funcionario == null) {
			funcionario = new Funcionario("1", "1", "1", "1", "1", "1");
		}
		return funcionario;
	}

}
