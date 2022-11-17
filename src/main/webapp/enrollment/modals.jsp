<%--
  Created by IntelliJ IDEA.
  User: magenta
  Date: 11/17/22
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%--Approve/Decline enrollment modal--%>
<div class="modal fade" id="modal${enrollment.id}" tabindex="-1" role="dialog"
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
                    <h4 class="card-title">Approve enrollment</h4>
                    <p class="card-description">Select status</p>

                    <form method="POST" action="../approveEnrollment">
                        <div class="form-group row">
                            <div class="col">
                                <input type="hidden" name="id"
                                       value="${enrollment.id}">
                                <label>Name</label>
                                <div id="the-basics">
                                    <input class="typeahead border border-success"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${enrollment.trainee.firstName} ${enrollment.trainee.lastName}"/>

                                </div>
                                <label>Training</label>
                                <div id="training">
                                    <input class="typeahead border border-success"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${enrollment.training.title}"/>
                                </div>

                            </div>
                            <div class="col">
                                <label>Status</label>
                                <div id="bloodhound">

                                    <select class="form-control border border-success" name="status"
                                            id="exampleSelectGender">
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

<%-- Delete enrollment modal--%>

<div class="modal fade" id="modal_delete${enrollment.id}" tabindex="-1" role="dialog"
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
                    <h4 class="card-title">Delete This record</h4>
                    <p class="card-description">Deleting this record will remove it permanently</p>

                    <form method="POST" action="../deleteEnrollment">
                        <div class="form-group row">
                            <div class="col">
                                <input type="hidden" name="id"
                                       value="${enrollment.id}">
                                <label>Trainee name</label>
                                <div id="username">
                                    <input class="typeahead border border-success"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${enrollment.trainee.firstName} ${enrollment.trainee.lastName}"/>

                                </div>

                            </div>
                            <div class="col">
                                <label>Training title</label>
                                <input class="typeahead border border-success"
                                       type="text"
                                       placeholder="Your name" disabled
                                       value="${enrollment.training.title}"/>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </div>
                    </form>

                </div>
            </div>

        </div>

    </div>
</div>

<%--Assessment form modal--%>
<div class="modal fade" id="assessment${enrollment.id}" tabindex="-1" role="dialog"
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
                    <h4 class="card-title">Assessment form</h4>
                    <p class="card-description">Fill the form and submit</p>

                    <form method="POST" action="../approveEnrollment">
                        <div class="form-group row">
                            <div class="col-12">
                                <input type="hidden" name="id"
                                       value="${enrollment.id}">
                                <label>Name</label>
                                <div id="the-basics1" class="mb-2 pb-2">
                                    <input class="typeahead border border-secondary"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${enrollment.trainee.firstName} ${enrollment.trainee.lastName}"/>

                                </div>
                                <label>Training Title</label>
                                <div id="trainingTitle" class="pb-2 mb-2">
                                    <input class="typeahead border border-secondary"
                                           type="text"
                                           placeholder="Your name" disabled
                                           value="${enrollment.training.title}"/>
                                </div>

                            </div>
                            <div class="col-12">
                                <label>Score (out of 100)</label>
                                <div id="score3" class="mb-2 pb-2">
                                    <input class="typeahead border border-success"
                                           type="number"
                                           max="99"
                                           min="1"
                                           placeholder="Score"/>
                                </div>

                                <label>Comment</label>
                                <div id="comment" class="mb-2">
                                    <textarea class="typeahead border border-primary" maxlength="35" required>

                                    </textarea>
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
