package ua.epam.spring.library.writer;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
public class WriterServiceImpl implements WriterService {
    WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public Writer find(Integer id) {
        return writerRepository.find(id);
    }

    @Override
    public List<Writer> find(List<Integer> ids) {
        return writerRepository.find(ids);
    }

    @Override
    public Writer findByName(String name) {
        return writerRepository.findByName(name);
    }

    @Override
    public boolean create(Writer writer) {
        return writerRepository.create(writer);
    }
}
