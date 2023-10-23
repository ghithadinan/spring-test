import {Link} from 'react-router-dom';

const Navigation = ({active = ''}) => {
    return <>
        <nav aria-label="breadcrumb">
            <ol className="breadcrumb p-3 bg-body-tertiary rounded-3">
                <li className="breadcrumb-item">{active !== 'user' ? <Link to="/">User</Link> : 'User'}</li>
                <li className="breadcrumb-item">{active !== 'form' ? <Link to="/add">Add</Link> : 'Add'}</li>
            </ol>
        </nav>
    </>;
};

export default Navigation;
