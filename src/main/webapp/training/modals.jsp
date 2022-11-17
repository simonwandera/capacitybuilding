<%--Assing trainer modal--%>
<div class="modal fade" id="assignModal${training.id}" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>


            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Assign trainer</h4>
                    <p class="card-description">Select trainer and click assign</p>

                    <form method="POST" action="../assignTrainer">
                        <div class="form-group row">
                            <div class="col">
                                <input type="hidden" name="id"
                                       value="${training.id}">
                                <label>Training Title</label>
                                <div id="the-basics mb-2 pb-2">
                                    <input class="typeahead border border-success"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${training.title}"/>

                                </div>

                            </div>
                            <div class="col">
                                <label>Status</label>
                                <div id="bloodhound">

                                    <select class="form-control border border-success" name="status" id="exampleSelectGender">
                                        <option>APPROVED</option>
                                        <option>DECLINED</option>
                                    </select>

                                </div>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>

                </div>
            </div>

        </div>

    </div>
</div>