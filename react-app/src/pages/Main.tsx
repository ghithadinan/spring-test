import {useState} from "react";
import axios from 'axios';

interface Person {
    yearOfDeath: number;
    ageOfDeath: number;
    yearOfBirth?: number;
    numberOfPeopleKilled?: number;
}

interface Calculate {
    persons: Person[];
    averageNumberOfVictims?: number;
}

const Main = () => {
    const title = 'Geekseat Sorcerer Saga';
    const [loading, setLoading] = useState(false);

    const defaultPerson: Person =
        {
            yearOfDeath: 0,
            ageOfDeath: 0
        };

    const defaultCalculate = {
        persons: [],
        averageNumberOfVictims: 0
    };

    const [persons, setPersons] = useState<Person[]>([defaultPerson]);
    const [calculate, setCalculate] = useState<Calculate>(defaultCalculate);

    function add() {
        setPersons(prevState => [...prevState, defaultPerson]);
        setCalculate(defaultCalculate);
    }

    function remove(idx: number) {
        if (window.confirm(`Are you sure want to delete row number ${idx + 1} ?`)) {
            setPersons([
                ...persons.slice(0, idx),
                ...persons.slice(idx + 1)
            ]);
            setCalculate(defaultCalculate);
        }
    }

    function submitData() {
        setLoading(true);
        const postData = persons.map(({yearOfBirth, numberOfPeopleKilled, ...keepAttrs}) => keepAttrs)
        axios.post('http://localhost:8080/api/calculate', postData).then((res) => {
            const calculate: Calculate = res.data.data;
            setCalculate(calculate);
            setPersons(calculate.persons);
            console.info('calculate', calculate);
            setLoading(false);
        }).catch((e) => {
            console.error('e', e);
            setLoading(false);
        });
    }

    function resetData() {
        setPersons([defaultPerson]);
        setCalculate(defaultCalculate);
    }

    return <div className="container my-5">
        <h4>{title}</h4>
        <form className="row g-3 needs-validation mt-5">
            {persons.map((p, i) => {
                return <div key={i} className="row">
                    <div className="col-lg-8">
                        <div className="row">
                            <div className="col-md-1">
                                <label className="form-label"><strong>{i + 1}</strong>.</label>
                            </div>
                            <div className="col-md-5">
                                <label className="form-label">Age Of Death</label>
                                <input type="text"
                                       autoFocus={true}
                                       className="form-control"
                                       onChange={(e) => {
                                           setPersons(prevState => {
                                               const copy: Person[] = JSON.parse(JSON.stringify(prevState));
                                               const person: Person = copy[i];
                                               person.ageOfDeath = !isNaN(parseInt(e.target.value)) ? parseInt(e.target.value) : 0;
                                               return copy;
                                           });
                                       }} value={p.ageOfDeath}/>
                            </div>
                            <div className="col-md-4">
                                <label className="form-label">Year Of Death</label>
                                <input type="text"
                                       className="form-control"
                                       onChange={(e) => {
                                           setPersons(prevState => {
                                               const copy: Person[] = JSON.parse(JSON.stringify(prevState));
                                               const person: Person = copy[i];
                                               person.yearOfDeath = !isNaN(parseInt(e.target.value)) ? parseInt(e.target.value) : 0;
                                               return copy;
                                           });
                                       }} value={p.yearOfDeath}/>
                            </div>
                            <div className="col-md-2">
                                {i === (persons.length - 1) &&
                                    <button type="button" className="btn btn-success btn-sm me-1" title="Add"
                                            disabled={loading}
                                            onClick={() => add()}>Add
                                    </button>}
                                {persons.length > 1 &&
                                    <button type="button" className="btn btn-danger btn-sm" title="Remove"
                                            disabled={loading}
                                            onClick={() => remove(i)}>Remove
                                    </button>
                                }
                            </div>
                        </div>
                        <div className="row mt-3">
                            <div className="col-md-6">
                                <label className="form-label">Year Of Birth</label>
                                <input type="text"
                                       disabled={true}
                                       className="form-control"
                                       onChange={(e) => e.preventDefault()}
                                       value={p.yearOfBirth ?? 0}/>

                            </div>
                            <div className="col-md-6">
                                <label className="form-label">Number Of People Killed</label>
                                <input type="text"
                                       disabled={true}
                                       className="form-control"
                                       onChange={(e) => e.preventDefault()}
                                       value={p.numberOfPeopleKilled ?? 0}/>
                            </div>
                        </div>
                        <hr className="mb-4"/>
                    </div>
                </div>;
            })}
            <div className="row">
                <div className="col-lg-8">
                    <div className="row">
                        <div className="col-md-6 position-relative">
                            <p className="position-absolute end-0 mt-1"><strong>Average Number Of Victims</strong></p>
                        </div>
                        <div className="col-md-6">
                            <input type="text"
                                   disabled={true}
                                   className="form-control"
                                   onChange={(e) => e.preventDefault()}
                                   value={calculate.averageNumberOfVictims}/>
                        </div>
                    </div>
                </div>
            </div>
            <div className="col-12 mt-3">
                <button type="button" className="btn btn-primary btn-sm" disabled={loading}
                        onClick={() => submitData()}>Sumbit
                </button>
                <button type="button" className="btn btn-warning btn-sm ms-1" disabled={loading}
                        onClick={() => resetData()}>Reset
                </button>
            </div>
        </form>
    </div>
};

export default Main;
