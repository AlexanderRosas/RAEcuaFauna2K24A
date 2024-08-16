package DataAccess.IDAO;

import java.util.List;

import DataAccess.DTO.EstudianteDTO;

public interface EstudianteDAO {
    void save(EstudianteDTO estudiante) throws Exception;
    EstudianteDTO getByCodigoUnico(String codigoUnico) throws Exception;
    List<EstudianteDTO> getAll() throws Exception;
    void update(EstudianteDTO estudiante) throws Exception;
    void delete(String codigoUnico) throws Exception;
}