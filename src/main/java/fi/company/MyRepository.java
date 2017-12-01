package fi.company;



    /**
     * Base interface for handling database actions.
     *
     * @author Max Power
     * @version 2017-04-12
     */
    public interface MyRepository<T, ID> {
        public T saveEntity(T entity);
        public Iterable<T> findAll();
    }

