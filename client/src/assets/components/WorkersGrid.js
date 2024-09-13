// WorkersGrid.js
import WorkerCard from './WorkerCard';  // Asume que WorkerCard está definido correctamente

function WorkersGrid({ workers }) {
  return (
    <div className="container mx-auto px-4 ">
      <h1 className="text-left text-4xl font-bold mb-5  pl-16 text-gray-800 ">Albañilería (151)</h1>
      <div className="flex flex-wrap justify-center gap-4">
        {workers.map(worker => (
          <WorkerCard key={worker.id} worker={worker} />
        ))}
      </div>
    </div>
  );
}

export default WorkersGrid;
